package cc.cynara.lanqiao.SFTG;

import java.util.Scanner;

/**
编写函数，其功能为把一个十进制数转换为其对应的八进制数。程序读入一个十进制数，调用该函数实现数制转换后，输出对应的八进制数。
 样例输入
 9274
 样例输出
 22072
样例输入
 18
 样例输出
 22
 * @author liutao-REMIX 
 *
 */
public class ADV_097_2016_3_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		System.out.println(Integer.toOctalString(s));
	}
}
