package cc.cynara.lanqiao.JCTG;

import java.util.Scanner;

/**
问题描述
　　从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
样例输入
FFFF
样例输出
65535
 * @author liutao-REMIX 
 *
 */
public class Basic_11_2016_3_9 {
	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		System.out.println(result(str));
	}
	static int result(String str){
		double s = 0;
		int len = str.length();
		for (int j = 0; j < str.length(); j++) {
			char c = str.charAt(j);
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
		return (int)s;
	}
}
