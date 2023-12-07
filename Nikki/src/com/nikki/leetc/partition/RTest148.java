package com.nikki.leetc.partition;

import com.nikki.leetc.ListNode;

/**
 *排序链表
 *@author:Jesse
 *@version:2023年12月6日下午11:44:51
**/
public class RTest148 {

	public static void main(String[] args) {
		int[] nums = {4,2,1,3};
		ListNode list = ListNode.constructList(nums);
		

	}
	/**
	 * 给你链表的头结点head，请将其按升序排列并返回排序后的链表。
	 * 输入：head = [4,2,1,3]
	 * 输出：[1,2,3,4]
	 * @param head
	 * @return
	 */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode newHead = head;
        while (temp != null) {
            if (temp.val < ) {
                
            }
        }
        
    }
}
