package cc.cynara.lanqiao.SFXL;

import java.util.Arrays;
import java.util.Scanner;

/**
问题描述
给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。
输入格式
第一行包含一个数n，表示序列长度。
第二行包含n个正整数，表示给定的序列。
第三个包含一个正整数m，表示询问个数。
接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。
输出格式
总共输出m行，每行一个数，表示询问的答案。
样例输入
5
1 2 3 4 5
2
1 5 2
2 3 2
样例输出
4
2
数据规模与约定
对于30%的数据，n,m<=100；
对于100%的数据，n,m<=1000；
保证k<=(r-l+1)，序列中的数<=106。
 * @author liutao-REMIX 
 *
 */
public class ALGO_001_2016_3_10 {
	public static void main(String[] args) {
		//用户输入相关
		int n = new Scanner(System.in).nextInt();
		int nums[] = new int[n];
		String str = new Scanner(System.in).nextLine();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(str.split(" ")[i]);
		}
		int m = new Scanner(System.in).nextInt();
		int lrk[][] = new int[m][3];
		for (int i = 0; i < lrk.length; i++) {
			str = new Scanner(System.in).nextLine();
			for (int j = 0; j < lrk[i].length; j++) {
				lrk[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		result(nums, lrk);
	}
	/**
	 * 
	 * @param nums  用户输入的数组
	 * @param lrk  用户输入的条件二维数组
	 */
	static void result(int[] nums,int[][] lrk){
		for (int i = 0; i < lrk.length; i++) {
			int flag[] = new int[lrk[i][1]-lrk[i][0]+1];
			int f = 0;
			for (int j = lrk[i][0]-1; j < lrk[i][1]; j++) {
				flag[f] = nums[j];
				f++;
			}
			//排序  取值
			Arrays.sort(flag);
			System.out.println(flag[flag.length-lrk[i][2]]);
		}
	}
}
