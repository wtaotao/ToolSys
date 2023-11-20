package com.nikki.leetc.list;
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

	    public LRUCache(int capacity) {

	    }
	    
	    public int get(int key) {

	    }
	    
	    public void put(int key, int value) {

	    }
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}