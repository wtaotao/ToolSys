/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.leetc;

import com.nikki.out.Print;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @filename ListNode.java
 * @version v0.1 2023年11月29日
 * @time 下午2:06:21 
 *
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode constructList(int[] nums) {
        //输入整数数组为空，则返回空
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode prev = null;
        for (int i = 0; i <= nums.length-1; i++) {
            if (head == null) {
                head = new ListNode(nums[i]);
                prev = head;
            } else {
                prev.next = new ListNode(nums[i]);
                prev = prev.next;
            }
        }
        return head;
    }
    public static void print(ListNode list) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (list != null) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(list.val);
            list = list.next;
        }
        sb.append("]");
        Print.stringOut(sb.toString());
    }
}
