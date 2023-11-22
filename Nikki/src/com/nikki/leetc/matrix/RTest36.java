package com.nikki.leetc.matrix;

import java.util.HashSet;

import com.nikki.out.Print;

/**
 * 有效的数独
 * @author Jesse
 *
 */
public class RTest36 {
	public static void main(String[] args) {
		char[][] board = 
            {{'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
		Print.stringOut("Is valid sudoku?" + isValidSudoku(board));
	}
	/**
	 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
	 * 数字 1-9 在每一行只能出现一次。
	 * 数字 1-9 在每一列只能出现一次。
	 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
	 * 注意：
	 * 一个有效的数独（部分已被填充）不一定是可解的。
	 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
	 * 空白格用 '.' 表示。
	 * @param board
	 * @return
	 */
	public static boolean isValidSudoku1(char[][] board) {
	    boolean isValid = true;
		HashSet<Character>[] columnFlag = new HashSet[9];
		HashSet<Character>[] rowFlag = new HashSet[9];
		for (int i = 0; i < 9; i++) {
		    HashSet<Character> set = new HashSet<Character>();
//		    for (int j = 1; j <= 9; j++) {
//		        set.add(j);
//		    }
		    columnFlag[i] = set;
		    rowFlag[i] = (HashSet<Character>) set.clone();
		}
		HashSet<Character>[][] subMartixFlag = new HashSet[3][3];
		for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
		        HashSet<Character> set = new HashSet<Character>();
//		        for (int k = 1; k <= 9; k++) {
//		            set.add(k);
//		        }
		        subMartixFlag[i][j] = set;
		    }
		}
		
		for (int i = 0; i < 9; i++) {
		    for (int j = 0; j < 9; j++) {
		        if (board[i][j] == '.') {
		            continue;
		        }
		        if (rowFlag[i].contains(board[i][j])) {
		            isValid = false;
		            break;
		        }
		        if (columnFlag[j].contains(board[i][j])) {
		            isValid = false;
		            break;
		        }
		        if (subMartixFlag[i/3][j/3].contains(board[i][j])) {
		            isValid = false;
		            break;
		        }
		    }
		    if (!isValid) break; 
		}
	    return isValid;
	}
    public boolean isValidSudoku(char[][] board) {
        //定义数字行内出现的次数
        int[][] row = new int[9][9];
        //定义数字列内出现的次数
        int[][] column = new int[9][9];
        //定义数字九宫格内出现的次数最大为9次
        int[][][] jiugongge = new int[3][3][9];
        //遍历数组
        for (int i =0;i <9;i++){
            for(int j = 0;j<9;j++){
                char c = board[i][j];
                //只要存在数字
                if (c !='.'){
                    //把数字-1化成索引下标,c是字符串要减去字符串，-1会报错。
                    int index = c-'1';
                    //这个时候++意思是第i行这个c值次数+1，默认row第二位就是{1-9}-1；每一行都有可能是1-9
                    //例如现在是第一行第一列是9，就在row[1][8]号位置+1
                    row[i][index]++;
                    //列同理
                    column[j][index]++;
                    //并且九宫格内次数也要+1,例如也是第1行第一列，i/3 j/3会自动定位到所在的小宫格
                    jiugongge[i/3][j/3][index]++;
                    //次数大于1就不成立一个数独
                    if (row[i][index]>1||column[j][index]>1||jiugongge[i/3][j/3][index]>1) return false;
                }
            }
        }
        return true;
    }
}
