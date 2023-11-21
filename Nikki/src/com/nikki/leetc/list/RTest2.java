package com.nikki.leetc.list;

import java.util.ArrayList;
import java.util.List;

import com.nikki.out.Print;

/**
 * 两数相加
 * @author Jesse
 *
 */
public class RTest2 {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		l1.add(4);
		l1.add(3);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(5);
		l2.add(6);
		l2.add(4);
		List l = addTwoNumbers(l1, l2);
		for (Object val: l) {
		    Print.stringOut("" + val);
		}

	}
	/**
	 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
	 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
	 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * 输入：l1 = [2,4,3], l2 = [5,6,4]
	 * 输出：[7,0,8]
	 * 解释：342 + 465 = 807.
	 * @param l1
	 * @param l2
	 * @return
	 */
    public static List addTwoNumbers(List<Integer> l1, List<Integer> l2) {
        List<Integer> list = new ArrayList<Integer>();
        //假设两个源列表长度一样
        int i = 0,carry = 0;
        do {
            int sum = l1.get(i) + l2.get(i) + carry;
            carry = sum/10;
            list.add(sum%10);
            i++;
        } while (i<l1.size());
        if (carry == 1) list.add(1);
        return list;
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
}
