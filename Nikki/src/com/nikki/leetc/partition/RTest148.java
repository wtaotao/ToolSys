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
		ListNode newList = sortList(list);
        //输出排序后的链表
		ListNode.print(newList);
	}
	/**
	 * 给你链表的头结点head，请将其按升序排列并返回排序后的链表。
	 * 输入：head = [4,2,1,3]
	 * 输出：[1,2,3,4]
	 * @param head
	 * @return
	 */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //创建一个临时表头前节点
        ListNode formerNode = new ListNode(0, head);
        int count = 1;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            int i = 0;
            ListNode temp = formerNode.next;
            ListNode prev = formerNode;
            for (; i < count; i++) {
                if (p.val < temp.val) {
                    prev.next = p;
                    p = p.next;
                    prev.next.next = temp;
                    //已有序队列长度加一
                    count++;
                    break;
                }
                //比待插入节点小则跟后面一个对比
                prev = temp;
                temp = temp.next;
            }
            //如果已排序节点全小于待插入节点，则插到最后
            if (i == count) {
                temp.next = p;
                p = p.next;
                count++;
            }
        }
        //返回临时头节点之后的节点
        return formerNode.next;  
    }
}
