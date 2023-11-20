package com.nikki.leetc.hash;

import java.util.HashMap;
import java.util.HashSet;

import com.nikki.out.Print;

/**
 * 赎金信
 * @author Jesse
 *
 */
public class RTest383 {

	public static void main(String[] args) {
//		String ransomNote = "a", magazine = "b";
//		String ransomNote = "aa", magazine = "aab";
		String ransomNote = "fihjjjjei", magazine = "hjibagacbhadfaefdjaeaebgi";
		Print.stringOut("Can construct?" + canConstruct(ransomNote, magazine));
	}
	/**
	 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
	 * 如果可以，返回 true ；否则返回 false 。
	 * magazine 中的每个字符只能在 ransomNote 中使用一次。
	 * 输入：ransomNote = "a", magazine = "b"
	 * 输出：false
	 * 提示
	 * 1 <= ransomNote.length, magazine.length <= 105
	 * ransomNote 和 magazine 由小写英文字母组成
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public static boolean canConstruct(String ransomNote, String magazine) {
		boolean canConstruct = false;
		if (ransomNote == null || ransomNote.length() == 0) {
		    return true;
		} else {
		    if (magazine == null || magazine.length() < ransomNote.length()) {
		        return false;
		    }
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//假定无重复字符，否则需修改程序
		for (int i = 0; i < magazine.length(); i++) {
			if (map.containsKey(magazine.charAt(i))) {
				map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
			} else {
				map.put(magazine.charAt(i), 1);
			}
		}
		int i = 0;
		for (; i < ransomNote.length(); i++) {
		    if (map.containsKey(ransomNote.charAt(i))) {
		    	if (map.get(ransomNote.charAt(i)) > 1) {
		    		map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
		    	} else {
		    		map.remove(ransomNote.charAt(i));
		    	}
		    } else {
		        canConstruct = false;
		        break;
		    }
		}
		if (i == ransomNote.length()) {
		    canConstruct = true;
		}
		return canConstruct;
	}
}
