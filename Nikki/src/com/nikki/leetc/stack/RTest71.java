package com.nikki.leetc.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import com.nikki.out.Print;

/**
 * 简化路径
 * @author Jesse
 *
 */
public class RTest71 {

	public static void main(String[] args) {
//		String path = "/home/";
//		String path = "/../";
//		String path = "/home//foo/";
		String path = "/a/./b/../../c/";
		Print.stringOut(simplifyPath(path));
	}
	/**
	 * 给你一个字符串 path ，表示指向某一文件或目录的Unix风格绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
	 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分
	 * 。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
	 * 请注意，返回的 规范路径 必须遵循下述格式：
	 * 始终以斜杠 '/' 开头。
	 * 两个目录名之间必须只有一个斜杠 '/' 。
	 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
	 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
	 * 返回简化后得到的规范路径 。
	 * 输入：path = "/home/"
	 * 输出："/home"
	 * 解释：注意，最后一个目录名后面没有斜杠。 
	 * @param path
	 * @return
	 */
    public static String simplifyPath(String path) {
        String[] names = path.split("/");
        //这个还不能用单纯的栈呢，得用双端队列
        Deque<String> stack = new ArrayDeque<>(); 
        for (String name : names) {
            if ("..".equals(name)) { // 对于两个点，需要将目录切换到上一级
                if (!stack.isEmpty()) { // 所以只要栈不为空【因为不管如何取上一级，到/根目录也就停了】，就弹出栈顶元素
                    stack.pollLast(); // 弹出栈顶元素
                }
            } else if (name.length() > 0 && !".".equals(name)) { // 不是空字符串或者一个点
                stack.offerLast(name); // 否则就是目录名，直接入栈
            }
        }
        // 全部对last进行poll或者offer就是栈的形式，想想一下
        StringBuilder builder = new StringBuilder();
        if (stack.isEmpty()) {
            builder.append('/');
        } else {
            while (!stack.isEmpty()) {
                builder.append('/').append(stack.pollFirst()); // 先进去的先出来，这样结果才对
            }
        }
        return builder.toString();
    }
}
