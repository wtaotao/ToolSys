package com.nikki.leetc.math;

import com.nikki.out.Print;

/**
 *加一
 *@author:Jesse
 *@version:2023年12月12日下午11:40:20
**/
public class RTest66 {

	public static void main(String[] args) {
		int[] digits = {1,2,3};
        Print.arrayOut(plusOne(digits));
	}
	/**
	 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
	 * 最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
	 * 你可以假设除了整数0之外，这个整数不会以零开头。
	 * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字123。
	 * @param digits
	 * @return
	 */
    public static int[] plusOne(int[] digits) {
        //思路：考虑进位
        int carry = 0;
        for (int i = digits.length-1; i >= 0; i--) {
            if (i == digits.length-1) {
                digits[i] = digits[i] + 1;
            }
            digits[i] = digits[i] + carry;
            carry = digits[i]/10;
            //无进位则高位计算中断
            if (carry == 0) {
                break;
            } else {
                //有进位则取个位数
                digits[i] = digits[i]%10;
            }
        }
        //最高位有进位
        if (carry == 1) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i-1];
            }
            return newDigits;
        }
        //最高位无进位
        return digits;
    }
}
