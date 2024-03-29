package com.nikki.leetc.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 * @author Jesse
 *
 */
public class RTest49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
	 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
	 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
	 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
	}
}
