package com.nikki.leetc.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 * @author Jesse
 *
 */
public class RTest155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class MinStack {
	    Deque<Integer> xStack;
	    Deque<Integer> minStack;
	/**
	 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
	 * 实现 MinStack 类:
	 * MinStack() 初始化堆栈对象。
	 * 输入：
	 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
	 * [[],[-2],[0],[-3],[],[],[],[]]
	 * 输出：
	 * [null,null,null,null,-3,null,0,-2]
	 */
    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    /**
     * void push(int val) 将元素val推入堆栈。
     * @param val
     */
    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }
    /**
     * void pop() 删除堆栈顶部的元素。
     */
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    /**
     * int top() 获取堆栈顶部的元素。 
     * @return
     */
    public int top() {
        return xStack.peek();
    }
    /**
     * int getMin() 获取堆栈中的最小元素。
     * @return
     */
    public int getMin() {
        return minStack.peek();
    }
	}
}
