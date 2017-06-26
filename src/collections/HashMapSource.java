/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import com.sun.xml.internal.fastinfoset.util.KeyIntMap;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-4-27
 *
 */
public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    /*
     默认的初始容量，必须为2的幂
     */
    static final int DEFAULE_INITIAL_CAPACITY = 16;
    /*
     最大容量（必须为2的幂且小于2的30次方，传入容量过大将被这个值替换）
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;
    /*
     默认装载因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /*
     存储数据的Entry数组，长度是2的幂。
     */
    transient Entry[] table;

    transient int size;

    int threshold;

    final float loadFactor;

    transient volatile int modCount;

    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int) (DEFAULE_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        table = new Entry[DEFAULE_INITIAL_CAPACITY];
        init();
    }

    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity:" + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        int capacity = 1;

        while (capacity < initialCapacity) {
            capacity <<= 1;
        }
        this.loadFactor = loadFactor;
        threshold = (int) (capacity * loadFactor);

        table = new Entry[capacity];
        init();

    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(Map<? extends K, ? extends V> m) {
        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1, DEFAULE_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);

        putAllForCreate(m);
    }

    static class Entry<K, V> implements Map.Entry<K, V> {

        final K key;
        V value;
        Entry<K, V> next; //对下一个节点的引用(看到链表的内容,结合定义的Entry数组,是不是想到了哈希表的拉链法实现)
        final int hash; //哈希值

        Entry(int h, K k, V v, Entry<K, V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;  //返回的是之前的Value
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {  //先判断类型是否一致
                return false;
            }

            Map.Entry e = (Map.Entry<K, V>) o;
            Object k1 = getKey();
            Object k2 = e.getKey();
// Key相等且Value相等则两个Entry相等
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2))) {
                    return true;
                }
            }
            return false;
        }
        /*
         hashCode是Key的hashCode和Value的hashCode的异或的结果
         */

        public final int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }
        /*
         重写toString方法,使输出更加清晰
         */

        public final String toString() {
            return getKey() + " " + getValue();
        }

        /*
         当调用put(k,v)方法存入键值对时,如果k已经存在,则该方法被调用(为什么没有内容)
         */
        void recordAccess(HashMap<K, V> m) {

        }

        /**
         * 当Entry被从HashMap中移除时被调用（为什么没有内容？）
         */
        void recordRemoval(HashMap<K, V> m) {
        }

    }

    public V put(K key, V value) {
        if (key == null) {
            return putForNullKey(value);

        }
        int hash = hash(key.hashCode());
        int i = KeyIntMap.indexFor(hash, table.length);

        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            Object k;
            //判断该条链上是否有hash值相同的(key相同)
            if (e.hash == hash && ((key = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }

        }

        modCount++;
        addEntry(hash, key, value, i);
        return null;
    }

    /*
     猜测: Java中 int值占4个字节,即32位.根据这32位值进行移位/异或运算得到一个值.
     */
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    void addEntry(int hash, K key, V value, int bucketIndex) {

        //获取bucketIndex处的Entry
        Entry<K, V> e = table[bucketIndex];
        //将新创建的Entry放入 bucketIndex 索引处,并让新的Entry指向原来的Entry
        table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
        if (size++ >= threshold) {
            resize(2 * table.length);
        }
    }
    
    public V get(Object key){
        if (key==null) {
            return getForNullKey();
        }
        int hash = hash(key.hashCode());
        
        for (Entry<K,V>  e = table[indexFor(hash,table.length)]; e!=null;e=e.next ) {

            Object k ;
            
            if (e.hash ==hash && ((k=e.key)==key || key.equals(k))) {
                return  e.value;
            }
        }
    }
    
    void resize(int newCapacity){
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        
        // 这个if块表明,如果容量已经达到允许的最大值,即MAXIMUN_CAPACITY,则不再扩展容量,而将装载扩展的界限值设为计算机允许的最大值.
        //不会再触发resize方法,而是不断的向map中添加内容,即table数组中的链表可以不断增长,但数组长度不再改变
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        
        //创建新数组,容量为指定的容量  
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        // 设置下一次需要调整数组大小的界限
        threshould = (int) (newCapacity * loadFactor);
    }

}
