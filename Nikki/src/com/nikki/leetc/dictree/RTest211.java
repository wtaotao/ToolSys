package com.nikki.leetc.dictree;
/**
 * 添加与搜索单词 - 数据结构设计
 *@author:Jesse
 *@version:2023年11月26日下午11:39:36
**/
public class RTest211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 请你设计一个数据结构，支持添加新单词和查找字符串是否与任何先前添加的字符串匹配 。
	 * 实现词典类 WordDictionary：
	 * 输入：
     * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
     * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
     * 输出：
     * [null,null,null,null,false,true,true,true]
     * 1 <= word.length <= 25
     * addWord中的word由小写英文字母组成
     * search中的word由'.'或小写英文字母组成
     * 最多调用10^4次addWord和search
	 * @author Jesse
	 *
	 */
	class WordDictionary {
	    private Trie root;
        /**
         * WordDictionary()初始化词典对象
         */
	    public WordDictionary() {
	        root = new Trie();
	    }
	    /**
	     * void addWord(word)将word添加到数据结构中，之后可以对它进行匹配
	     * @param word
	     */
	    public void addWord(String word) {
	        root.insert(word);
	    }
	    /**
	     * bool search(word)如果数据结构中存在字符串与word匹配，则返回true；否则，返回false。word中可能包含一些'.' ，
	     * 每个.都可以表示任何一个字母。
	     * @param word
	     * @return
	     */
	    public boolean search(String word) {
	        return dfs(word, 0, root);
	    }
	    private boolean dfs(String word, int index, Trie node) {
	        if (index == word.length()) {
	            return node.isEnd();
	        }
	        char ch = word.charAt(index);
	        if (Character.isLetter(ch)) {
	            int childIndex = ch - 'a';
	            Trie child = node.getChildren()[childIndex];
	            if (child != null && dfs(word, index + 1, child)) {
	                return true;
	            }
	        } else {
	            for (int i = 0; i < 26; i++) {
	                Trie child = node.getChildren()[i];
	                if (child != null && dfs(word, index + 1, child)) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }


class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
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

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }
	}
	}

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary();
	 * obj.addWord(word);
	 * boolean param_2 = obj.search(word);
	 */
}
