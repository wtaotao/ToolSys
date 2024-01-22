package com.nikki.leetc.dictree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 单词搜索 II
 *@author:Jesse
 *@version:2023年11月26日下午11:42:18
**/
public class RTest212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定一个mxn二维字符网格board和一个单词（字符串）列表words，返回所有二维网格上的单词。
	 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
	 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
	 * 输出：["eat","oath"]
	 * 
	 * @param board
	 * @param words
	 * @return
	 */
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        //创建trie,插入单词
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        //结果集合
        Set<String> ans = new HashSet<String>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                //从每一个单元格开始查找单词
                dfs(board, trie, i, j, ans);
            }
        }
        //返回结果集合
        return new ArrayList<String>(ans);
    }
    /**
     * 
     * <pre>
     * 深度遍历
     * </pre>
     *
     * @param board 字符网格
     * @param now 搜索单词集合
     * @param i1 字符网格行
     * @param j1 字符网格列
     * @param ans 结果集合
     */
    public void dfs(char[][] board, Trie now, int i1, int j1, Set<String> ans) {
        //如果没有搜索单词以当前字符开始，则返回
        if (!now.children.containsKey(board[i1][j1])) {
            return;
        }
        //取出当前网格字符
        char ch = board[i1][j1];
        now = now.children.get(ch);
        //若当前节点是叶子节点（即已收到搜索单词），则插入结果集
        if (!"".equals(now.word)) {
            ans.add(now.word);
        }
        //搜索过并成为单词部分的打标记改为#
        board[i1][j1] = '#';
        for (int[] dir : dirs) {
            //行号+1，列号+0--下##行号-1，列号+0--上##行号+0，列号+1--右##行号+0，列号-1--左
            int i2 = i1 + dir[0], j2 = j1 + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                //分别对下、上、右、左进行遍历查找
                dfs(board, now, i2, j2, ans);
            }
        }
        //回退改回之前的字符
        board[i1][j1] = ch;
    }
}

class Trie {
    String word;
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        this.word = "";
        this.children = new HashMap<Character, Trie>();
    }

    public void insert(String word) {
        Trie cur = this;
        //遍历每个word字符，按树节点一个个存储起来，没有则创建新节点
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        //叶子节点标记
        cur.word = word;
    }
}
