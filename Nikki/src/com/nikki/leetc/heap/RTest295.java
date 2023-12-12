package com.nikki.leetc.heap;

import com.nikki.out.Print;

/**
 *数据流的中位数
 *@author:Jesse
 *@version:2023年12月11日下午11:34:57
**/
public class RTest295 {

	public static void main(String[] args) {
	    RTest295 test = new RTest295();
	    MedianFinder mfinder = test.new MedianFinder();
	    mfinder.addNum(1);
	    mfinder.addNum(2);
	    Print.stringOut("The median is:" + mfinder.findMedian());
	    mfinder.addNum(3);
	    Print.stringOut("The median is:" + mfinder.findMedian());
	}
	/**
	 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
	 * 例如 arr = [2,3,4] 的中位数是 3 。
	 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
	 * 实现 MedianFinder 类:
	 * MedianFinder() 初始化 MedianFinder 对象。
	 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
	 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
	 * 输入
     * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
     * [[], [1], [2], [], [3], []]
     * 输出
     * [null, null, null, 1.5, null, 2.0]
     *
	 * @author Jesse
	 *
	 */
	class MedianFinder {
	    private int[] nums = null;
	    private int count = 0;

	    public MedianFinder() {
            nums = new int[16];
            count = 0;
	    }
	    
	    public void addNum(int num) {
	        //扩容
            if (count == nums.length) {
                int[] temp = new int[nums.length*2];
                for (int i = 0; i < nums.length; i++) {
                    temp[i] = nums[i];
                }
                nums = temp;
            }
            //比较并插入
            if (count == 0) {
                nums[0] = num;
            }
            for (int i = count-1; i >= 0; i--) {
                if (nums[i] <= num) {
                    nums[i+1] = num;
                    break;
                } else {
                    nums[i+1] = nums[i];
                    //插入元素比现有所有元素小
                    if (i == 0) {
                        nums[i] = num;
                    }
                }
            }
            count++;
	    }
	    
	    public double findMedian() {
	        double res = 0.0;
            if (count%2 == 0) {
                res = (double)(nums[count/2] + nums[count/2 - 1])/2;
            } else {
                res = nums[count/2];
            }
            return res;
	    }
	}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */
}
