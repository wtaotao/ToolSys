package com.nikki.sample;

public class BubbleSort {
	/**
	 * 生成随机整数数组
	 * 
	 * @param size
	 * @param value
	 * @return
	 */
	int[] generateRandomArray(int size, int value) {
		// 在java中，Math.random() ->double(0,1)
		// (int)((size+1)*Math.random())--->产生的是[0,size]之间的整数
		// 生成长度随机的数组，数组的最大长度是size的长度
		int[] arr = new int[(int) ((size + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			// 针对数组中的每个值都可以随机一下，一个随机数减去另外一个随机数，可能产生正数，也可能产生负数
			arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
			// 值也可以是随机的
		}
		return arr;
	}

	int[] sort(int[] array) {
		// 一定要记住判断边界条件
		if (array == null || array.length < 2) {
			return array;
		} // 需要进行array.length趟比较
		for (int i = 0; i < array.length - 1; i++) {
			// 第i趟比较
			for (int j = 0; j < array.length - i - 1; j++) {
				// 开始进行比较，如果array[j]比array[j+1]的值大，那就交换位置
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
}
