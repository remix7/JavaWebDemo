package cc.cynara.lanqiao._2015_B;

import java.util.Scanner;
/**
5. 把一个整数的每个数位都平方后求和，又得到一个整数，我们称这个整数为：位平方和。
对新得到的整数仍然可以继续这一运算过程。
比如，给定整数为4，则一系列的运算结果为：
16,37,58,89,....
本题的要求是，已知一个整数x，求第n步的运算结果。
数据格式要求：
输入，两个整数x n，中间以空格分开。表示求x的第n步位平方和。其中，x，n都大于0，且小于100000。
输出，一个整数，表示所求结果。
例如，
输入：
4 3
则程序应该输出：
58
再例如，
输入：
1314 10
则程序应该输出：
20

 * @author REMIX-7
 *
 */
public class _2015_B_5 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int num1 = Integer.parseInt(str.split(" ")[0]);
		int num2 = Integer.parseInt(str.split(" ")[1]);
		System.out.println(jisuan(num1, num2));
	}

	private static int jisuan(int num1, int num2) {
		int num = num1;
		String s = num + "";
		int temp =0;
		int result =0;
		for (int i = 0; i < num2; i++) {
			result = 0;
			for (int j = 0; j < s.length(); j++) {
				temp = Integer.parseInt(s.charAt(j)+"")*Integer.parseInt(s.charAt(j)+"");
				result+=temp;
			}
			
			s  =  result+"";
			
		}
		return result;
	}

}
