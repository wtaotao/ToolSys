package com.nikki.leetc.list;

import java.util.ArrayList;
import java.util.List;

import com.nikki.leetc.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * @author Jesse
 *
 */
public class RTest82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回已排序的链表 。
	 * 输入：head = [1,2,3,3,4,4,5]
	 * 输出：[1,2,5]
	 * @param head
	 * @return
	 */
	//上面例子输出错误
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode h = head;
        if (h == null || h.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        while (h != null) {
            list.add(h);
            h = h.next;
        }
        ListNode temp = null;
        for (int i = 0; i < list.size();) {
            if (temp != null) {
                if (list.get(i).val == temp.val) {
                    list.get(i).next = null;
                    i++;
                } else {
                    temp = null;
                }
            } else {
                if (i < list.size()-1 && list.get(i).val == list.get(i+1).val) {
                    temp = list.get(i);
                } else {
                    i++;
                }
            }
        }
        boolean lastUnique = false;
        if (temp != null) {
            lastUnique = true;
        }
        head = null;
        ListNode prev = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).next == null) {
                if (!(i == list.size()-1 && lastUnique)) {
                    list.remove(i);
                }
            } else {
                if (head == null) head = list.get(i);
                if (prev == null) {
                    prev = list.get(i);
                } else {
                    prev.next = list.get(i);
                }
            }
        }
        return head;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
