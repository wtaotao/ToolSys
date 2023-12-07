package com.nikki.leetc.list;

import com.nikki.leetc.ListNode;
import com.nikki.out.Print;

/**
 * 合并两个有序链表
 * @author Jesse
 *
 */
public class RTest21 {

	public static void main(String[] args) {
	    RTest21 test = new RTest21();
		int[] l1 = {1,2,4};
		int[] l2 = {1,3,4};
		ListNode next = null;
		for (int i = l1.length-1; i >= 0; i--) {
		    ListNode node = new ListNode(l1[i]);
		    if (i == l1.length-1) {
		        node.next = null;
		    } else {
		        node.next = next;
		    }
		    next = node;
		}
		ListNode h1 = next;
		for (int i = l2.length-1; i >= 0; i--) {
		    ListNode node = new ListNode(l2[i]);
		    if (i == l2.length-1) {
		        node.next = null;
		    } else {
		        node.next = next;
		    }
		    next = node;
		}
		ListNode h2 = next;
		
		ListNode h = test.mergeTwoLists(h1, h2);

		while (h != null) {
		    Print.stringOut("The val is："+ h.val);
		    h = h.next;
		}
	}
	/**
	 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
	 * 输入：l1 = [1,2,4], l2 = [1,3,4]
	 * 输出：[1,1,2,3,4,4]
	 * @param list1
	 * @param list2
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = null, temp = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (temp == null) {
                    temp = list1;
                } else {
                    temp.next = list1;
                }
                list1 = list1.next;
            } else {
                if (temp == null) {
                    temp = list2;
                } else {
                    temp.next = list2;
                }
                list2 = list2.next;
            }
            if (head == null) {
                head = temp;
            } else {
                temp = temp.next;
            }
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return head;
    }
}
