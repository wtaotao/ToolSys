package com.nikki.leetc.bitwise;
/**
 *位1的个数
 *@author:Jesse
 *@version:2023年12月11日下午11:40:52
**/
public class RTest191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
	 * 提示：
     * 请注意，在某些语言（如Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
     * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 在Java中，编译器使用二进制补码记法来表示有符号整数。因此，在示例3中，输入表示有符号整数-3。
     * 输入：n = 00000000000000000000000000001011
     * 输出：3
	 * @param n
	 * @return
	 */
    //you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            //统计最后一位的1
            res += n & 1;
            //最高位补0右移一位
            n >>>= 1;
        }
        return res;
    }
}
