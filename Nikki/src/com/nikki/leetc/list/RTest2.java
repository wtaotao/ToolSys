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
//		List<Integer> l1 = new ArrayList<Integer>();
//		l1.add(2);
//		l1.add(4);
//		l1.add(3);
//		List<Integer> l2 = new ArrayList<Integer>();
//		l2.add(5);
//		l2.add(6);
//		l2.add(4);
//		List l = addTwoNumbers(l1, l2);
//		for (Object val: l) {
//		    Print.stringOut("" + val);
//		}
	    RTest2 test = new RTest2();
	    ListNode l1 = test.new ListNode(2);
	    ListNode h1 = l1;
	    l1.next = test.new ListNode(4);
	    l1 = l1.next;
	    l1.next = test.new ListNode(3);
	    l1 = l1.next;
	    l1.next = test.new ListNode(8);
	    ListNode l2 = test.new ListNode(5);
	    ListNode h2 = l2;
	    l2.next = test.new ListNode(6);
	    l2 = l2.next;
	    l2.next = test.new ListNode(6);
	    ListNode l = test.addTwoNumbers(h1, h2);
	    while (l != null) {
	        Print.stringOut("" + l.val);
	        l = l.next;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //如有有一个列表为空，则直接返回另一个列表
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //从个位开始计算，进位加到下一高位
    	ListNode h = null, l = null;
    	int carry = 0;
    	do {
    		int sum = l1.val + l2.val + carry;
    		carry = sum/10;
    		if (l == null) {
    			l = new ListNode(sum%10);
    			h = l;
    		} else {
    			l.next = new ListNode(sum%10);
    			l = l.next;
    		}
    		l1 = l1.next;
    		l2 = l2.next;
    	} while (l1 != null && l2 != null);
    	//l1比l2长，高位直接跟进位运算
    	while (l1 != null) {
    		int sum = l1.val + carry;
    		carry = sum/10;
    		l.next = new ListNode(sum%10);
    		l = l.next;
    		l1 = l1.next;
    		
    	};
    	//l2比l1长，高位直接跟进位运算
    	while (l2 != null) {
    	    int sum = l2.val + carry;
    	    carry = sum/10;
    	    l.next = new ListNode(sum%10);
    	    l = l.next;
    	    l2 = l2.next;
    	}
    	if (carry == 1) 
    		l.next = new ListNode(1);
    	return h;
    }
    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
