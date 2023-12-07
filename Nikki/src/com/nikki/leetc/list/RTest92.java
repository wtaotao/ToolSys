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
    public ListNode reverseBetween1(ListNode head, int left, int right) {
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
