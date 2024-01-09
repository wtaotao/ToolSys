package com.nikki.leetc;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本左右对齐
 * @author Jesse
 *
 */
public class RTest68 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给定一个单词数组words和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
	 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有maxWidth个字符。
	 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
	 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
	 * 注意:
	 * 单词是指由非空格字符组成的字符序列。
	 * 每个单词的长度大于0，小于等于maxWidth。
	 * 输入单词数组words至少包含一个单词。
	 * @param words
	 * @param maxWidth
	 * @return
	 */
    public List<String> fullJustify(String[] words, int maxWidth) {
        //初始化结果列表
        List<String> res = new ArrayList<>();
        int cnt = 0, bg = 0;
        for (int i = 0; i < words.length; i++) {
            cnt += words[i].length() + 1;
            // 如果是最后一个单词，或者加上下一个词就超过长度了，即可凑成一行
            if (i + 1 == words.length || cnt + words[i + 1].length() > maxWidth) {
                // 对每行单词进行空格平均划分
                res.add(fillWords(words, bg, i, maxWidth, i + 1 == words.length));
                bg = i + 1;
                cnt = 0;
            }
        }
        return res;
    }
    /**
     * 对每行单词进行空格平均划分
     */
    private String fillWords(String[] words, int bg, int ed, int maxWidth, boolean lastLine) {
        //单词个数
        int wordCount = ed - bg + 1;
        // 除去每个单词尾部空格， +1是最后一个单词的尾部空格的特殊处理
        int spaceCount = maxWidth + 1 - wordCount;
        for (int i = bg; i <= ed; i++) {
            // 除去所有单词的长度
            spaceCount -= words[i].length();
        }
        // 词尾空格
        int spaceSuffix = 1;
        // 额外空格的平均值 = 总空格数/间隙数
        int spaceAvg = (wordCount == 1) ? 1 : spaceCount / (wordCount - 1);
        // 额外空格的余数
        int spaceExtra = (wordCount == 1) ? 0 : spaceCount % (wordCount - 1);
        // 填入单词
        StringBuilder sb = new StringBuilder();
        for (int i = bg; i < ed; i++) {
            sb.append(words[i]);
            if (lastLine) {
                sb.append(" ");
                continue;
            }
            int n = spaceSuffix + spaceAvg + (((i - bg) < spaceExtra) ? 1 : 0);
            while (n-- > 0) {
                sb.append(" ");
            }
        }
        // 填入最后一个单词
        sb.append(words[ed]);
        // 补上这一行最后的空格
        int lastSpaceCnt = maxWidth - sb.length();
        while (lastSpaceCnt -- > 0){
            sb.append(" ");
        }
        return sb.toString();
    }
}
