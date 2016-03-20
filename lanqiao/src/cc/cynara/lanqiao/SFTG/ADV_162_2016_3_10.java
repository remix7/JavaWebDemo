package cc.cynara.lanqiao.SFTG;

import java.util.Arrays;
import java.util.Scanner;

/**
问题描述
　　给定 N 个整数，请你找出这 N 个数中最大的那个和最小的那个。
输入格式
　　第一行包含一个正整数 N 。(1 ≤ N ≤ 10000)。
　　第二行为 N 个用空格隔开的整数,每个数的绝对值不超过 1000000。
输出格式
　　输出仅一行,包含两个整数 x,y，x 表示 N 个数中的最大值，y 表示 N 个数中的最小值。x,y 之间用一个空格隔开。
样例输入
4
2 0 1 2
样例输出
2 0
 * @author liutao-REMIX 
 *
 */
public class ADV_162_2016_3_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int irr[] = new int[n];
		for (int i = 0; i < irr.length; i++) {
			irr[i] = sc.nextInt();
		}
		Arrays.sort(irr);
		System.out.print(irr[irr.length-1]+" "+irr[0]);
	}
}
