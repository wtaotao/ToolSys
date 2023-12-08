package com.nikki.leetc.partition;

import com.nikki.leetc.ListNode;

/**
 *合并K个升序链表
 *@author:Jesse
 *@version:2023年12月6日下午11:48:18
**/
public class RTest23 {

	public static void main(String[] args) {
	    ListNode[] lists = new ListNode[3];
	    lists[0] = ListNode.constructList(new int[] {1,4,5});
	    lists[1] = ListNode.constructList(new int[] {1,3,4});
	    lists[2] = ListNode.constructList(new int[] {2,6});
	    ListNode mlist = mergeKLists(lists);
        ListNode.print(mlist);
	}
	/**
	 * 给你一个链表数组，每个链表都已经按升序排列。
	 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
	 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
	 * 输出：[1,1,2,3,4,4,5,6]
	 * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
	 * @param lists
	 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
	 * @return
	 */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, list = null;
        ListNode minNode = new ListNode(Integer.MAX_VALUE);
        while (minNode != null) {
            minNode = new ListNode(Integer.MAX_VALUE);
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minIndex = i;
                }
            }
            if (minNode.val != Integer.MAX_VALUE) {
                if (list == null) {
                    list = minNode;
                    head = list;
                } else {
                    list.next = minNode;
                    list = list.next;
                }
                lists[minIndex] = lists[minIndex].next;
            } else {
                minNode = null;
            }
        }
        return head;
    }
}
