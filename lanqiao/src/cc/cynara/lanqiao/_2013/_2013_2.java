package cc.cynara.lanqiao._2013;

import java.util.Scanner;
/**
 * 标题: 组素数
    素数就是不能再进行等分的数。比如：2 3 5 7 11 等。
    9 = 3 * 3 说明它可以3等分，因而不是素数。
    我们国家在1949年建国。如果只给你 1 9 4 9 这4个数字卡片，可以随意摆放它们的先后顺序（但卡片不能倒着摆放啊，我们不是在脑筋急转弯！），那么，你能组成多少个4位的素数呢？
    比如：1949，4919 都符合要求。
请你提交：能组成的4位素数的个数，不要罗列这些素数!!
注意：不要提交解答过程，或其它的辅助说明文字。
*
*1949 1994 1499 9491 9419 9941 9914 9194 9149 4991 4919 4199
*尾数为偶数的去掉 重复去掉
*1949 1499 9941 9491 9419 9149 4991 4919 4199
*
*
 * 1949 1499 9941 9491 9419 4919 6个素数
 * @author REMIX-7
 *
 */
public class _2013_2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int num = Integer.parseInt(str);
		int flag=0;
		for (int i = 2; i <= num/2; i++) {
			if(num%i==0){
				flag++;
			}
		}
		System.out.println(flag);
	}
}
