package com.nikki.leetc.map.scopesearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 单词接龙
 *@author:Jesse
 *@version:2023年11月26日下午11:33:30
**/
public class RTest127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 字典wordList中从单词beginWord和endWord的转换序列是一个按下述规格形成的序列beginWord -> s1 -> s2 -> ... -> sk：
	 * 每一对相邻的单词只差一个字母。
	 *  对于 1 <= i <= k 时，每个si都在wordList中。注意，beginWord不需要在wordList中。
	 *  sk == endWord
	 *  给你两个单词beginWord和endWord和一个字典wordList，返回从beginWord到endWord的最短转换序列中的单词数目。如果不存在这样的转换序列，返回0。
	 *  输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
	 *  输出：5
	 *  解释：一个最短转换序列是"hit" -> "hot" -> "dot" -> "dog" -> "cog",返回它的长度5。
	 * 
	 */
    //广度优先遍历
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第1步：先将wordList放到哈希表里，便于判断某个单词是否在wordList里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        
        // 第2步：图的广度优先遍历，必须使用队列和表示是否访问过的visited哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        // 第3步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 如果currentWord能够修改1个字符与endWord相同，则返回step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对currentWord修改每一个字符，看看是不是能与endWord匹配
     *
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @return
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        //把当前词转换成字符数组
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 先保存，然后恢复
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            charArray[i] = originChar;
        }
        return false;
    }
}
