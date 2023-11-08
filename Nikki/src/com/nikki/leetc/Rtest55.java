package com.nikki.leetc;
/**
 * 跳跃游戏
 * @author Jesse
 *
 */
public class Rtest55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个非负整数数组nums ，你最初位于数组的第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
	 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
	 * @param nums
	 * @return
	 */
    public boolean canJump(int[] nums) {
    	
       if (nums[nums.length-1] == 0) return true;    	
       int index = 0, value=0;
       do {
    	   if (index == nums.length-1) {
    		   return true;
    	   } else {
    		   if (nums[index] == 0) return false;
    	   }
    	   value = nums[index];
    	   index = index + value;
       }while(index <= (nums.length-1));
       return false;
    }
}
