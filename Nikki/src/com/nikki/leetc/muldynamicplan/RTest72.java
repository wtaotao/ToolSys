package com.nikki.leetc.muldynamicplan;
/**
 *编辑距离
 *@author:Jesse
 *@version:2023年12月13日下午10:56:01
**/
public class RTest72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你两个单词word1和word2，请返回将word1转换成word2所使用的最少操作数。
	 * 你可以对一个单词进行如下三种操作：
	 * 插入一个字符
	 * 删除一个字符
	 * 替换一个字符
	 * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse(将'h'替换为'r')
     * rorse -> rose(删除'r')
     * rose -> ros(删除'e')
	 * @param word1
	 * @param word2
	 * @return
	 */
    public int minDistance(String word1, String word2) {
        //思路：替换=删除+插入，相当于两步操作，因此优先替换
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];  
    }
}
