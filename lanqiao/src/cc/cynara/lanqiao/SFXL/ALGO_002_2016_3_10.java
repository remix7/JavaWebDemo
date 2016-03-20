package cc.cynara.lanqiao.SFXL;

import java.util.Scanner;

/**
问题描述
已知一个正整数N，问从1~N中任选出三个数，他们的最小公倍数最大可以为多少。
输入格式
输入一个正整数N。
输出格式
输出一个整数，表示你找到的最小公倍数。
样例输入
9
样例输出
504
数据规模与约定
1 <= N <= 106。
 * @author liutao-REMIX 
 *
 */
public class ALGO_002_2016_3_10 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
			if(n%2==0){
				System.out.println((long)n*(n-1)*(n-3));
			}else{
				System.out.println((long)n*(n-1)*(n-2));
			}
	}
}
