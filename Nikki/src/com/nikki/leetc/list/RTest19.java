package com.nikki.leetc.list;

import com.nikki.leetc.ListNode;
import com.nikki.out.Print;

/**
 * 删除链表的倒数第 N 个结点
 * @author Jesse
 *
 */
public class RTest19 {

	public static void main(String[] args) {
	    RTest19 test = new RTest19();
	    int[] nums = {1,2,3,4,5};
	    ListNode head = null, prev = null;
	    for (int i = 0; i < nums.length; i++) {
	        ListNode node = new ListNode(nums[i]);
	        if (i == 0) {
	            head = node;
	            prev = node;
	        } else {
	            prev.next = node;
	            prev = prev.next;
	        }
	    }
		ListNode newHead = removeNthFromEnd(head, 3);
        while (newHead != null) {
            Print.stringOut("val:" + newHead.val);
            newHead = newHead.next;
        }
	}
	/**
	 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
	 * 输入：head = [1,2,3,4,5], n = 2
	 * 输出：[1,2,3,5]
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {

	    /**
	     * 思路：删除对应的节点，返回链表
	     */
	    ListNode temp = head;
	    int i = 0;
	    while (temp != null) {
	        i++;
	        temp = temp.next;
	    }
	    ListNode[] list = new ListNode[i];
	    temp = head;
	    i = 0;
	    while (temp != null) {
	        list[i++] = temp;
	        temp = temp.next;
	    }
	    if (n <= list.length) {
	       int index = list.length - n;
	       if (index == 0) {
	           temp = head.next;
	           head.next = null;
	           head = temp;
	           return head;
	       }
	       temp = list[index];
	       list[index-1].next = temp.next;
	       temp.next = null;
	    }
	    return head;
    }
}
