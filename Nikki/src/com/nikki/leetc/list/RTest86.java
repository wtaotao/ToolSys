package com.nikki.leetc.list;

import com.nikki.leetc.ListNode;
import com.nikki.out.Print;

/**
 * 分隔链表
 * @author Jesse
 *
 */
public class RTest86 {

	public static void main(String[] args) {
		RTest86 test = new RTest86();
        int[] nums = {1,4,3,2,5,2};
        int x = 3;
        ListNode next = null;
        for (int i = nums.length-1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            node.next = next;
            next = node;
        }
        ListNode newList = test.partition(next, x);
        while (newList != null) {
            Print.stringOut("val :" + newList.val);
            newList = newList.next;
        }       
	}
	/**
	 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
	 * 你应当 保留 两个分区中每个节点的初始相对位置。
	 * 输入：head = [1,4,3,2,5,2], x = 3
	 * 输出：[1,2,2,4,3,5]
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition1(ListNode head, int x) {
		ListNode temp = head;
		if (temp == null || temp.next == null) {
		    return head;
		}
		//先找出第一个大于等于x的节点mark
		ListNode mark = null;
		ListNode mprev = null;
		while (temp != null) {
		    if (temp.val < x) {
		        mprev = temp;
		        temp = temp.next;
		    } else {
		        mark = temp;
		        break;
		    }
		}
		//没有不小于x的节点
		if (temp == null) {
		    return head;
		}
		//从标记点往后搜索
		ListNode tprev = temp;
		temp = temp.next;
		while (temp != null) {
		    if (temp.val < x) {
		        //移除
		        ListNode swap = temp;
		        temp = temp.next;
		        tprev.next = temp;
		        //插入，mprev可能为null
		        mprev.next = swap;
		        mprev = mprev.next;
		        swap.next = mark;
		    } else {
		        tprev = temp;
		        temp = temp.next;
		    }
		}
	    return head;
	}
    public ListNode partition(ListNode head, int x) {
        ListNode smlDummy = new ListNode(0), bigDummy = new ListNode(0);
        ListNode sml = smlDummy, big = bigDummy;
        while (head != null) {
            if (head.val < x) {
                sml.next = head;
                sml = sml.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        sml.next = bigDummy.next;
        big.next = null;
        return smlDummy.next;
    }
}
