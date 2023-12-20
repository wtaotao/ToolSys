package com.nikki.leetc.onedynamicplan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nikki.out.Print;

/**
 *单词拆分
 *@author:Jesse
 *@version:2023年12月13日下午9:50:02
**/
public class RTest139 {

	public static void main(String[] args) {
		//s = "leetcode", wordDict = ["leet", "code"]
//	    String s = "leetcode";
//	    String[] words = {"leet", "code"};
	    String s = "cars";
	    String[] words = {"car","ca","rs"};
	    List<String> wordDict = new ArrayList<String>(words.length);
	    for (String word: words) {
	        wordDict.add(word);
	    }
	    
	    Print.stringOut("Is can?" + wordBreak(s, wordDict));
	}
	/**
	 * 给你一个字符串s和一个字符串列表wordDict作为字典。请你判断是否可以利用字典中出现的单词拼接出s。
	 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
	 * 输入: s = "leetcode", wordDict = ["leet", "code"]
	 * 输出: true
	 * 解释: 返回true, 因为"leetcode"可以由"leet"和"code"拼接成。
	 * @param s
	 * @param wordDict
	 * @return
	 */
	//"car","ca","rs"拼"cars"会出错
    public static boolean wordBreak1(String s, List<String> wordDict) {
        //思路：正向的话需要字符串切词比较麻烦，反过来用字典的每个单词去匹配字符串，匹配上的话改成空；最后判断字符串是否成了空字符串。
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.contains(wordDict.get(i))) {
                s = s.replaceAll(wordDict.get(i), "");
            }
        }
        return s.trim().isEmpty();
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
