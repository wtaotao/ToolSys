package com.nikki.sample;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.nikki.out.Print;
import com.nikki.sort.BubbleSort;
import com.nikki.thread.WorkerThread;

public class TestSample {
    private static final String MD5_SALT = "QAZWSXEDCRFV09876543210";
    private static Map AttrValueMap = new HashMap<>(16);
	public static void main(String[] args) {
//		System.out.println("Hello World!");
//		(new Test()).quickSort();
		
//		(new Test()).testBubbleSort();
//		(new Test()).checkpwd("123456");
//		(new Test()).testHashMap1();
		(new TestSample()).testThread1();
		(new TestSample()).testThread2();
	}
	
	private void testThread1() {
		Thread t = new WorkerThread(10);
		t.start();
	}  
	
	private void testThread2() {
		final int index = 0;
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Print.stringOut("Test thread2 -- " + index);
				
			}
			
		});
		t.start();
	}
	
	public static void checkpwd(String pwd) {
		
		if (null == pwd) {
			Print.stringOut("The input pwd is NULL!");
			return;
		}
		
		Print.stringOut("The input raw pwd is: " + pwd);
		String encryptPwd = encrypt(encrypt(pwd));
		Print.stringOut("The input encrypt pwd is: " + encryptPwd);
		encryptPwd = encryptBySalt(pwd);
		Print.stringOut("The input salt encrypt pwd is: " + encryptPwd);
	}
	
    public static String encrypt(String dataStr) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes(StandardCharsets.UTF_8));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (byte value : s) {
                result.append(Integer.toHexString((0x000000FF & value) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * <pre>
     * md5(md5(str+salt))两次MD5,一次加盐
     * </pre>
     */
    public static String encryptBySalt(String dataStr) {
        try {
            dataStr = dataStr + MD5_SALT;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes(StandardCharsets.UTF_8));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (byte value : s) {
                result.append(Integer.toHexString((0x000000FF & value) | 0xFFFFFF00).substring(6));
            }
            return encrypt(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
	
	void testBubbleSort() {
		
		BubbleSort bs = new BubbleSort();
		int[] array = bs.generateRandomArray(18, 11);
		Print.stringOut("The array before bubble sort is:");
		Print.arrayOut(array);
		int[] sortArray = bs.sort(array);
		Print.stringOut("The array after bubble sort is:");
		Print.arrayOut(sortArray);
	}

	private int quickSort() {
		int a[] = { 72, 6, 57, 88, 60, 42, 83, 73, 48, 85 };
//		printArray(a);
		quick_sort1(a, 0, 9);
//		printArray(a);
		return 0;
	}

	void quick_sort1(int s[], int l, int r) {
		if (l < r) {
			int i = adjustArray(s, l, r);// 先成挖坑填数法调整s[]
			quick_sort1(s, l, i - 1); // 递归调用
			quick_sort1(s, i + 1, r);
		}
	}

	private int adjustArray(int s[], int l, int r) // 返回调整后基准数的位置
	{
		int i = l, j = r;
		int x = s[l]; // s[l]即s[i]就是第一个坑
		while (i < j) {
			// 从右向左找小于x的数来填s[i]
			while (i < j && s[j] >= x)
				j--;
			if (i < j) {
				s[i] = s[j]; // 将s[j]填到s[i]中，s[j]就形成了一个新的坑
				i++;
			}

			// 从左向右找大于或等于x的数来填s[j]
			while (i < j && s[i] < x)
				i++;
			if (i < j) {
				s[j] = s[i]; // 将s[i]填到s[j]中，s[i]就形成了一个新的坑
				j--;
			}
		}
		// 退出时，i等于j。将x填到这个坑中。
		s[i] = x;

		return i;
	}

	// 复制数组
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	public static boolean isEqual(int[] arr1, int[] arr2) {
		
		if (arr1 == null && arr2 != null || arr1 != null && arr2 == null) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	void rightMethod (int[] arr){
		Arrays.sort(arr);   
		} 
	public static void setHashMapDesc(int number) {
		for(int i=0; i<number; i++) {
			AttrValueMap.put("index"+i, "example"+i);
		}
	}
	public static String getHashMapDesc() {
		StringBuffer sb = new StringBuffer();
		AttrValueMap.entrySet().stream().forEach(item->{
            if (sb.length()>0){
                sb.append(",");
                sb.append(item.toString());
            }else{
                sb.append(item.toString());
            }
        });
		return sb.toString();
	} 
	
	void testHashMap1() {
		setHashMapDesc(10);
		
		Print.stringOut(getHashMapDesc());
	}
	}