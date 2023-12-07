package com.nikki.leetc.list;

import com.nikki.leetc.ListNode;
import com.nikki.out.Print;

/**
 * 反转链表 II
 * @author Jesse
 *
 */
public class RTest92 {

	public static void main(String[] args) {
	    RTest92 test = new RTest92();
        int[] nums = {3,5};
        int left = 1, right = 2;
//        int[] nums = {1,2,3,4,5};
//        int left = 2, right = 4;
        ListNode next = null;
        for (int i = nums.length-1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            node.next = next;
            next = node;
        }
        ListNode newList = test.reverseBetween(next, left, right);
        while (newList != null) {
            Print.stringOut("val :" + newList.val);
            newList = newList.next;
        } 
	}
	/**
	 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，
	 * 返回 反转后的链表 。
	 * 输入：head = [1,2,3,4,5], left = 2, right = 4
	 * 输出：[1,4,3,2,5]
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
    public ListNode reverseBetween(ListNode head, int left, int right) {
    	if (left == right) return head;
        //假设left和right都不超过链表的边界
        int count = 0;
        ListNode temp = head;
        ListNode prev = null, n1 = null, n2 = null, tprev = null, swap = null;
        while (temp != null) {
            if (count < left-1) {
                prev = temp;
                temp = temp.next;
                count++;
            } else {
                //在反转区间
                if (count <= right-1) {
                    if (count == left-1) {
                        n1 = temp;
                        tprev = temp;
                        temp = temp.next;
                        count++;
                    } else if (count == right-1) {
                        n1.next = temp.next;
                        n2 = temp;
                        prev.next = n2;
                        n2.next = tprev;
                        break;
                    } else {
                        //反转
                        swap = temp;
                        temp = temp.next;
                        swap.next = tprev;
                        tprev = swap;
                        count++;
                    }
                }
            }
        }
        return head;
    }
}
