package com.nikki.sort;

public class QuickSort {
	
	int[] sort(int s[], int l, int r) {
		if (l < r) {
			// 先成挖坑填数法调整s[]
			int i = adjustArray(s, l, r);
			// 递归调用
			sort(s, l, i - 1); 
			sort(s, i + 1, r);
		}
		return s;
	}

	// 返回调整后基准数的位置
	private int adjustArray(int s[], int l, int r) 
	{
		int i = l, j = r;
		 // s[l]即s[i]就是第一个坑
		int x = s[l];
		while (i < j) {
			// 从右向左找小于x的数来填s[i]
			while (i < j && s[j] >= x)
				j--;
			if (i < j) {
				// 将s[j]填到s[i]中，s[j]就形成了一个新的坑
				s[i] = s[j]; 
				i++;
			}

			// 从左向右找大于或等于x的数来填s[j]
			while (i < j && s[i] < x)
				i++;
			if (i < j) {
				// 将s[i]填到s[j]中，s[i]就形成了一个新的坑
				s[j] = s[i]; 
				j--;
			}
		}
		// 退出时，i等于j。将x填到这个坑中。
		s[i] = x;

		return i;
	}
}
