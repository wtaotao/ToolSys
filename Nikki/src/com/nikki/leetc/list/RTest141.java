package com.nikki.leetc.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * @author Jesse
 *
 */
public class RTest141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个链表的头节点 head ，判断链表中是否有环。
	 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置
	 * （索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
	 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
	 * 输入：head = [3,2,0,-4], pos = 1
	 * 输出：true
	 * 解释：链表中有一个环，其尾部连接到第二个节点。
	 * @param head
	 * @return
	 */
    public boolean hasCycle(ListNode head) {
       /**
        * 思路：通过某个节点，沿着指针搜索，如果能回到本节点，说明有环。  
        */
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    
//    private class ListNode {
//        private int val;
//        private ListNode next;
//        
//        public ListNode(int val, ListNode node) {
//            this.val = val;
//            this.next = node;
//        }
//        
//        public void setVal(int val) {
//            this.val = val;
//        }
//        
//        public int getVal() {
//            return val;
//        }
//        
//        public void setNext(ListNode node) {
//            this.next = node;
//        }
//        
//        public ListNode getNext() {
//            return next;
//        }
//    } 
}
