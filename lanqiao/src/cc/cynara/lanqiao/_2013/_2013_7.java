package cc.cynara.lanqiao._2013;

import java.util.Scanner;

/**
标题：核桃的数量
小张是软件项目经理，他带领3个开发组。工期紧，今天都在加班呢。为鼓舞士气，小张打算给每个组发一袋核桃（据传言能补脑）。他的要求是：
1. 各组的核桃数量必须相同
2. 各组内必须能平分核桃（当然是不能打碎的）
3. 尽量提供满足1,2条件的最小数量（节约闹革命嘛）
程序从标准输入读入：
a b c
a,b,c都是正整数，表示每个组正在加班的人数，用空格分开（a,b,c<30）
程序输出：
一个正整数，表示每袋核桃的数量。
例如：
用户输入：
2 4 5
程序输出：
20
再例如：
用户输入：
3 1 1
程序输出：
3

思路：找三个数的最小公倍数
 * @author REMIX-7
 *
 */
public class _2013_7 {
	public static void main(String[] args) {
		String str = (new Scanner(System.in)).nextLine();
		int num1 = Integer.parseInt(str.split(" ")[0]);
		int num2 = Integer.parseInt(str.split(" ")[1]);
		int num3 = Integer.parseInt(str.split(" ")[2]);
		System.out.println(getMINBS(getMINBS(num1, num2),num3));
	}
	/**
	 * 求两个数的最小公倍数
	 * @param x
	 * @param y
	 * @return
	 */
	static int getMINBS(int x,int y){
		for(int i=1;i<x*y;i++){
			if(i%x==0&&i%y==0){
				return i;
			}
		}
		return x*y;
	}
}
