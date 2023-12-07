package com.nikki.leetc.list;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 * @author Jesse
 *
 */
public class RTest146 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 请你设计并实现一个满足LRU(最近最少使用)缓存约束的数据结构。
	 * 实现 LRUCache类：
	 * LRUCache(int capacity)以正整数作为容量capacity初始化LRU缓存
	 * int get(int key) 如果关键字key存在于缓存中，则返回关键字的值，否则返回-1。
	 * void put(int key, int value) 如果关键字key已经存在，则变更其数据值value；如果不存在，则向缓存中插入该组key-value。
	 * 如果插入操作导致关键字数量超过capacity ，则应该逐出最久未使用的关键字。
	 * 函数get和put必须以O(1)的平均时间复杂度运行。
	 * 输入["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
	 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
	 * 输出[null, null, null, 1, null, -1, null, -1, 3, 4]
	 * @author Jesse
	 *
	 */
	class LRUCache {
	    class DLinkedNode {
	        int key;
	        int value;
	        DLinkedNode prev;
	        DLinkedNode next;
	        public DLinkedNode() {}
	        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
	    }

	    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
	    private int size;
	    private int capacity;
	    private DLinkedNode head, tail;

	    public LRUCache(int capacity) {
	        this.size = 0;
	        this.capacity = capacity;
	        // 使用伪头部和伪尾部节点
	        head = new DLinkedNode();
	        tail = new DLinkedNode();
	        head.next = tail;
	        tail.prev = head;
	    }

	    public int get(int key) {
	        DLinkedNode node = cache.get(key);
	        if (node == null) {
	            return -1;
	        }
	        // 如果 key 存在，先通过哈希表定位，再移到头部
	        moveToHead(node);
	        return node.value;
	    }

	    public void put(int key, int value) {
	        DLinkedNode node = cache.get(key);
	        if (node == null) {
	            // 如果 key 不存在，创建一个新的节点
	            DLinkedNode newNode = new DLinkedNode(key, value);
	            // 添加进哈希表
	            cache.put(key, newNode);
	            // 添加至双向链表的头部
	            addToHead(newNode);
	            ++size;
	            if (size > capacity) {
	                // 如果超出容量，删除双向链表的尾部节点
	                DLinkedNode tail = removeTail();
	                // 删除哈希表中对应的项
	                cache.remove(tail.key);
	                --size;
	            }
	        }
	        else {
	            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
	            node.value = value;
	            moveToHead(node);
	        }
	    }

	    private void addToHead(DLinkedNode node) {
	        node.prev = head;
	        node.next = head.next;
	        head.next.prev = node;
	        head.next = node;
	    }

	    private void removeNode(DLinkedNode node) {
	        node.prev.next = node.next;
	        node.next.prev = node.prev;
	    }

	    private void moveToHead(DLinkedNode node) {
	        removeNode(node);
	        addToHead(node);
	    }

	    private DLinkedNode removeTail() {
	        DLinkedNode res = tail.prev;
	        removeNode(res);
	        return res;
	    }
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}
