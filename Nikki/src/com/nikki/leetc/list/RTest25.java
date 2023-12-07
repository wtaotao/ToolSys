package com.nikki.leetc.list;

import com.nikki.leetc.ListNode;
import com.nikki.out.Print;

/**
 *  K 个一组翻转链表
 * @author Jesse
 *
 */
public class RTest25 {

	public static void main(String[] args) {
        RTest25 test = new RTest25();
        int[] l = {1,2,3,4,5};
        ListNode next = null;
        for (int i = l.length-1; i >= 0; i--) {
            ListNode node = new ListNode(l[i]);
            if (i == l.length-1) {
                node.next = null;
            } else {
                node.next = next;
            }
            next = node;
        }
        ListNode list = test.reverseKGroup(next, 2);
        while (list != null) {
            Print.stringOut("The vol is:" + list.val);
            list = list.next;
        }
	}
	/**
	 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
	 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
	 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
	 * 输入：head = [1,2,3,4,5], k = 2
	 * 输出：[2,1,4,3,5]
	 * @param head
	 * @param k
	 * @return
	 */
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode p = head;
        ListNode[] list = new ListNode[k];
        int i = 0;
        boolean isFirst = true;
        ListNode prev = null;
        while (p != null) {
            list[i++] = p;
            p = p.next;
            if (i == k) {
                prev.next = list[0];
                reverse1(list);
                if (isFirst) {
                    head = list[k-1];
                    isFirst = false;
                }
                prev = list[0];
                i = 0;
            } 
            prev.next = p;
        }
        return head;
    }
    
    private void reverse1(ListNode[] list) {
        for (int i = 1; i < list.length; i++) {
            list[i].next = list[i-1];
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
