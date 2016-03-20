package cc.cynara.lanqiao._2015_B;

import java.util.Scanner;

/**
 * 有n级台阶。从地面（第0级）出发，首先连续的上台阶，上到不超过第n级的某一个位置后再连续的下台阶，直到回到地面。若每次上下台阶只允许走1级或2级，
 * 请问可能的上下台阶的方案数是多少？ 特别地，在0级站着不动也算一种方案。 数据格式： 输入一行包含两个正整数n和m。
 * 输出一个整数，表示n级台阶有多少种合法的走楼梯方案，答案对m取余。 例如：输入： 2 10007 程序应该输出 6 【样例说明1】
 * 共有6种方案(其中+表示上台阶，-表示下台阶)： (1) 原地不动 (2) +1 -1 (3) +2 -2 (4) +2 -1 -1 (5) +1 +1
 * -2 (6) +1 +1 -1 -1 再例如，输入： 3 14 程序应该输出： 1 【样例说明2】 共有15种方案，对14取余后得1。 
 * 思路： 有n个阶梯
 * 上楼梯的方案通过递归算出s 每一种上楼梯的方案对应的下楼梯的方案 都是跟上楼梯的方案一样多 就是s*s 上到n-1个阶梯下去是 同样通过递归计算
 * 并得出所有 n-1个台阶下楼梯方案 则n个阶梯的上下方案就是 n n-1 n-2 ...1 的所有上下楼图的和 别忘了 原地不动也是一种方案
 * 
 * @author REMIX-7
 * 
 */
public class _2015_B_7 {
	public static int upStep(int step) {
		if (step == 1)
			return 1;
		else if (step == 2)
			return 2;
		else
			return upStep(step - 1) + upStep(step - 2);
	}

	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		int step = Integer.parseInt(str.split(" ")[0]);
		int count = Integer.parseInt(str.split(" ")[1]);
		int sum = 0;
		while (step > 0) {
			sum += upStep(step) * upStep(step);
			step--;
		}
		System.out.println((sum + 1) % count);
	}
}
