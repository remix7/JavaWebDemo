package cc.cynara.lanqiao.SFTG;

import java.util.Arrays;
import java.util.Scanner;

/**
问题描述
　　对于n个数，从中取出m个数，如何取使得这m个数的乘积最大呢？
输入格式
　　第一行一个数表示数据组数
　　每组输入数据共2行：
　　第1行给出总共的数字的个数n和要取的数的个数m，1<=n<=m<=15，
　　第2行依次给出这n个数，其中每个数字的范围满足:a[i]的绝对值小于等于4。
输出格式
　　每组数据输出1行，为最大的乘积。
样例输入
1
5 5
1 2 3 4 2
样例输出
 * @author liutao-REMIX 
 *
 */
public class ADV_015_2016_3_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int k = 0; k < n; k++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int irr[] = new int[num1];
			for (int i = 0; i < irr.length; i++) {
				irr[i] = sc.nextInt();
			} 
			Arrays.sort(irr);
			int sum = 1;
			for (int i = irr.length-1; i >= irr.length-num2; i--) {
				sum*=irr[i];
			}
			a[k] = sum;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
