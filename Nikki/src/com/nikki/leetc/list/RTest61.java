package com.nikki.leetc.list;

import java.util.ArrayList;
import java.util.List;

import com.nikki.leetc.ListNode;
import com.nikki.out.Print;

/**
 * 旋转链表
 * @author Jesse
 *
 */
public class RTest61 {

	public static void main(String[] args) {
	    RTest61 test = new RTest61();
		int[] nums = {1,2,3,4,5};
		int k = 3;
        ListNode next = null;
        for (int i = nums.length-1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            node.next = next;
            next = node;
        }
        ListNode newList = rotateRight(next, k);
        while (newList != null) {
            Print.stringOut("val :" + newList.val);
            newList = newList.next;
        }
	}
	/**
	 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
	 * 输入：head = [1,2,3,4,5], k = 2
	 * 输出：[4,5,1,2,3]
	 * @param head
	 * @param k
	 * @return
	 */
	//head = [1,2] k = 0 出错
	public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int len = list.size();
        int mov = k%len;
        ListNode newLast = list.get((2*len-1-mov)%len);
        head = newLast.next;
        newLast.next = null;
        ListNode oldLast = list.get(len-1);
        ListNode oldFirst = list.get(0);
        oldLast.next = oldFirst;
        
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
