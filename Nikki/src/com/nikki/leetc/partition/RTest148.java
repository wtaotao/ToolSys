package com.nikki.leetc.partition;

import com.nikki.leetc.ListNode;

/**
 *排序链表
 *@author:Jesse
 *@version:2023年12月6日下午11:44:51
**/
public class RTest148 {

	public static void main(String[] args) {
//		int[] nums = {4,2,1,3};
		int[] nums = {-1,5,3,4,0};
		ListNode list = ListNode.constructList(nums);
		ListNode newList = (new RTest148()).sortList(list);
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
    public static ListNode sortList1(ListNode head) {
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
                if (i != count-1) {
                	prev = temp;
                	temp = temp.next;
                }
            }
            //如果已排序节点全小于待插入节点，则插到最后
            if (i == count) {
                temp.next = p;
                p = p.next;
                temp.next.next = null;
                count++;
            }
        }
        //返回临时头节点之后的节点
        return formerNode.next;  
    }
    
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
