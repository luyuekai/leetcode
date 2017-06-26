/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacheModel;

import java.util.Hashtable;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-5-3
 *
 */
public class LRUcache {

    class DLinkedNode {

        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();  //类型推导
    
    private int count;
    private int capacity;
    private DLinkedNode head, tail;
    
    public LRUcache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DLinkedNode();
        head.pre = null;
        
        tail = new DLinkedNode();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;
    }
    
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        
        pre.post = post;
        post.pre = pre;
    }
    
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
    
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if (node == null) {
            
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            
            ++count;
            
            if (count>capacity) {
                DLinkedNode last = this.popTail();
                this.cache.remove(last.key);
                --count;
            }
        }else{
            node.value = value;
            this.moveToHead(node);
        }
    }
    
}
