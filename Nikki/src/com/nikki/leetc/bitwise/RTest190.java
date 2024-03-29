package com.nikki.leetc.bitwise;
/**
 *颠倒二进制位
 *@author:Jesse
 *@version:2023年12月11日下午11:39:09
**/
public class RTest190 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 颠倒给定的32位无符号整数的二进制位--高低位互换。
	 * 提示：
	 * * 请注意，在某些语言（如Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是
	 * * 有符号的还是无符号的，其内部的二进制表示形式都是相同的。
	 * * 在Java中，编译器使用二进制补码记法来表示有符号整数。因此，在示例2中，输入表示有符号整数-3，输出表示有符号整数-1073741825。
	 * 输入：n = 00000010100101000001111010011100
     * 输出：964176192 (00111001011110000010100101000000)
	 * @param n
	 * @return
	 */
    //you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            //从最低位至最高位转移至结果上
            rev |= (n & 1) << (31 - i);
            //>>代表负数右移用1补位, 正数右移用0补位; >>>无论正负都用0补位
            n >>>= 1;
        }
        return rev;
    }
}
