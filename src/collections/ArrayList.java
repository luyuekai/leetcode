/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-4-23
 *
 */
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    /**
     * 被标记为transient的属性在对象序列化的时候并不会被保存
     */
    private transient Object[] elementData;
    /*
     ArrayList的大小，但不是容量，是里面装有元素的数目
     */
    private int size;

    public ArrayList(int initialCapacity) {
        super();
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity :" + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
    }

    public ArrayList() {
        this(10);
    }

    public ArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        size = elementData.length;

        if (elementData.getClass() != Object[].class) {
            elementData = Arrays.copyOf(elementData, size, Object[].class);
        }
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;

    }

    public void ensureCapacity(int minCapacity) {
        modCount++;
        int oldCapacity = elementData.length;

        if (minCapacity > oldCapacity) {
            Object oldData[] = elementData;
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);

        }
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index:" + index + ",Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;

    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Index: " + index + ",Size: " + size);

        }
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);

        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
            System.arraycopy(a, 0, elementData, index, numNew);
        }
        size += numNew;
        return numNew != 0;
    }

    @Override
    public void clear() {
        modCount++;
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public Object clone() {
        try {
            ArrayList<E> v = (ArrayList<E>) super.clone();
            v.elementData = Arrays.copyOf(elementData, size);
            v.modCount = 0;
            return v;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
    /*
     indexOf 返回的只是首次出现该对象的位置,
     并不能返回所有的index    
     */

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }

        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /*
     只能返回一个,并不能返回所有的index
     */
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        RangeCheck(index);

        return (E) elementData[index];
    }

    private void RangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size" + size);
        }
    }

    @Override
    public E remove(int index) {
        RangeCheck(index);
        modCount++;
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }

        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        modCount++;
        int numMoved = size - toIndex;
        System.arraycopy(elementData, fromIndex, elementData, toIndex, numMoved);
        int newSize = size - (toIndex - fromIndex);
        while (size!=newSize) {            
            elementData[--size] = null;
        }
    }
    
    @Override
    public E set(int index,E element){
        RangeCheck(index);
        
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public Object[] toArray(){
        return Arrays.copyOf(elementData, size);
    }
    
    @Override
    public <T> T[] toArray(T[] a){
        if (a.length<size) {
            return (T[])Arrays.copyOf(elementData, size,a.getClass());
            
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length>size) {
            a[size] = null;
        }
        return a;
    }
    
    public void trimTosize(){
        modCount++;
        int oldCapacity = elementData.length;
        if (size<oldCapacity) {
            elementData = Arrays.copyOf(elementData, size);
        }
    }
    

}
