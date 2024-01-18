package com.nikki.leetc.dictree;
/**
 * 实现 Trie (前缀树)
 *@author:Jesse
 *@version:2023年11月26日下午11:36:13
**/
public class RTest208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Trie（发音类似 "try"）或者说前缀树是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
	 * 请你实现Trie类：
	 * 1 <= word.length, prefix.length <= 2000
	 * word和prefix仅由小写英文字母组成
	 * insert、search和startsWith调用次数总计不超过3*10^4次
	 * @author Jesse
	 *
	 */
	class Trie {
        /**
         * Trie()初始化前缀树对象。
         * 输入
         * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
         * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
         * 输出
         * [null, null, true, false, true, null, true]
         * 解释
         * Trie trie = new Trie();
         * trie.insert("apple");
         * trie.search("apple");   // 返回 True
         * trie.search("app");     // 返回 False
         * trie.startsWith("app"); // 返回 True
         * trie.insert("app");
         * trie.search("app");     // 返回 True
         */
	    private Trie[] children;
	    private boolean isEnd;
	    public Trie() {
	        children = new Trie[26];
	        isEnd = false;
	    }
	    /**
	     * void insert(String word)向前缀树中插入字符串word。
	     * @param word
	     */
	    public void insert(String word) {
	        Trie node = this;
	        for (int i = 0; i < word.length(); i++) {
	            char ch = word.charAt(i);
	            int index = ch - 'a';
	            if (node.children[index] == null) {
	                node.children[index] = new Trie();
	            }
	            node = node.children[index];
	        }
	        node.isEnd = true;
	    }
	    /**
	     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
	     * @param word
	     * @return
	     */
	    public boolean search(String word) {
	        Trie node = searchPrefix(word);
	        return node != null && node.isEnd;
	    }
	    /**
	     * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
	     * @param prefix
	     * @return
	     */
	    public boolean startsWith(String prefix) {
	    	return searchPrefix(prefix) != null;
	    }
	    private Trie searchPrefix(String prefix) {
	        Trie node = this;
	        for (int i = 0; i < prefix.length(); i++) {
	            char ch = prefix.charAt(i);
	            int index = ch - 'a';
	            if (node.children[index] == null) {
	                return null;
	            }
	            node = node.children[index];
	        }
	        return node;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
}
