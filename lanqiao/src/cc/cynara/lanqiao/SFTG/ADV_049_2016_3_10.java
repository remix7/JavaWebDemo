package cc.cynara.lanqiao.SFTG;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
编写函数Normalize，将复数归一化，即若复数为a+bi，归一化结果为a/sqrt(a*a+b*b) + i*b/sqrt(a*a+b*b) 。使用结构体指针类型作为函数参数可能是必要的。其中实部和虚部由键盘输入，输出为归一化结果，如果归一化结果的实部或虚部为小数的要求保留一位小数。
样例输入:（格式说明：3 4 分别为以空格隔开的实数的实部和虚部） 
3 4 
样例输出:
0.6+0.8i
样例输入: 
2 5
样例输出:
0.4+0.9i

 * @author liutao-REMIX 
 *
 */
public class ADV_049_2016_3_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double sa = a/(Math.sqrt(a*a+b*b));
		double sb = b/(Math.sqrt(a*a+b*b));
		DecimalFormat df = new DecimalFormat("#.#");
		System.out.println(df.format(sa)+"+"+df.format(sb)+"i");
		
	}
}
