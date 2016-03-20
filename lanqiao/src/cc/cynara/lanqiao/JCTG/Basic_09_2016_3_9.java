package cc.cynara.lanqiao.JCTG;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
问题描述
　　123321是一个非常特殊的数，它从左边读和从右边读是一样的。
　　输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
输入格式
　　输入一行，包含一个正整数n。
输出格式
　　按从小到大的顺序输出满足条件的整数，每个整数占一行。
样例输入
52
样例输出
899998
989989
998899
数据规模和约定
　　1<=n<=54。
 * @author liutao-REMIX 
 *
 */
public class Basic_09_2016_3_9 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		Vector<String> v = new Vector<String>();
		for (int a = 0; a <=9; a++) {
			for (int b = 0; b <=9; b++) {
				for (int c = 0; c <=9; c++) {
					for (int d = 0; d <=9; d++) {
						for (int e = 0; e <=9; e++) {
							if((a+b+c+d+e==n)&&a==e&&b==d){
								v.add(""+a+b+c+d+e);
							}
							for (int f = 0; f <=9; f++) {
								if((a+b+c+d+e+f==n)&&a==f&&b==e&&c==d){
									v.add(""+a+b+c+d+e+f);
								}
							}
						}
					}
				}
			}
		}
		int s[] = new int[v.size()];
		for (int i = 0; i <v.size(); i++) {
			s[i] = Integer.parseInt(v.get(i));
		}
		Arrays.sort(s);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
}
