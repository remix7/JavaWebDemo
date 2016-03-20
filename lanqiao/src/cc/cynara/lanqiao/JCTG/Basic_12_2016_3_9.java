package cc.cynara.lanqiao.JCTG;

import java.util.Scanner;
/**
问题描述
　　给定n个十六进制正整数，输出它们对应的八进制数。
输入格式
　　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
输出格式
　　输出n行，每行为输入对应的八进制正整数。
　　【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。
样例输入
　　2
　　39
　　123ABC
样例输出
　　71
　　4435274
 * @author liutao-REMIX 
 *
 */
public class Basic_12_2016_3_9 {
	static Scanner sc = new Scanner(System.in);
	static int n = sc.nextInt();
	static String[] res = new String[n];
	static long lrr[] = new long[n];
	public static void main(String[] args) {
		String str[] = new String[n];
		//给数组赋值
		for (int i = 0; i < str.length; i++) {
			str[i] = new Scanner(System.in).nextLine();
		}
		result(str);
		for (int i = 0; i < lrr.length; i++) {
			System.out.println(Integer.toOctalString((int)lrr[i]));
		}
	}
	/**
	 * 将用户输入的16进制数抓换为10进制
	 * @param str  用户输入的数  汇成一个数组
	 */
	static void result(String str[]){
		double s = 0;
		for (int i = 0; i < str.length; i++) {
			s = 0;  //这一步一定要有
			int len = str[i].length();
			for (int j = 0; j < str[i].length(); j++) {
				char c = str[i].charAt(j);
				//如果该数的一位在
				if(c>='0'&&c<='9'){
					s+=Integer.parseInt(c+"")*Math.pow(16, len-1);
					len--;
				}else {
					switch (c) {
					case 'A':
						s+=10*Math.pow(16, len-1);
						len--;
						break;
					case 'B':
						s+=11*Math.pow(16, len-1);
						len--;
						break;
					case 'C':
						s+=12*Math.pow(16, len-1);
						len--;
						break;
					case 'D':
						s+=13*Math.pow(16, len-1);
						len--;
						break;
					case 'E':
						s+=14*Math.pow(16, len-1);
						len--;
						break;
					case 'F':
						s+=15*Math.pow(16, len-1);
						len--;
						break;
					}
				}
			}
			lrr[i] = (long)s;
		}
	}
}
