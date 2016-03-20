package cc.cynara.lanqiao._2015;

import java.util.Scanner;

/**
 * 移动距离8.50  10.37X星球居民小区的楼房全是一样的，并且按矩阵样式排列。其楼房的编号为1,2,3... 当排满一行时，从下一行相邻的楼往反方向排号。
 * 比如：当小区排号宽度为6时，开始情形如下： 1 2 3 4 5 6 12 11 10 9 8 7 13 14 15 .....
 * 我们的问题是：已知了两个楼号m和n，需要求出它们之间的最短移动距离（不能斜线方向移动） 输入为3个整数w m n，空格分开，都在1到10000范围内
 * 要求输出一个整数，表示m n 两楼间最短移动距离。 例如： 用户输入： 6 8 2 则，程序应该输出： 4 再例如： 用户输入： 4 7 20
 * 则，程序应该输出： 5 资源约定： 峰值内存消耗（含虚拟机） < 256M CPU消耗 < 1000ms
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。 注意：主类的名字必须是：Main，否则按无效代码处理。
 * 
 * @author liutao-REMIX
 * 
 */
public class _2015_8 {
	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		int w = Integer.parseInt(str.split(" ")[0]);
		int m = Integer.parseInt(str.split(" ")[1]);
		int n = Integer.parseInt(str.split(" ")[2]);
		int s = 0;
		if (m > n)
			s = m / w + 1;
		else
			s = n / w + 1;
		int[][] x = new int[s][w];
		voluation(x);
		System.out.println(result(x, w, m, n));
	}
	/**
	 * 
	 * @param x  
	 * @param w  楼房的宽度  
	 * @param m  房间一
	 * @param n  房间二
	 * @return 最终的结果
	 */
	static int result(int[][] x,int w, int m, int n) {
		int len = w;
		int num1 = 0;
		int s1 = 0, s2 = 0;
		if(m / len > n / len){
			if(m>w&&n>w){
				num1 = m / len - n / len -1; 
			}else{
				num1 = m / len - n / len;
			}
		}else{
			if(m>w&&n>w){
				num1 = n / len - m / len - 1; 
			}
		}
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] == m) {
					s1 = j;
				}
				if (x[i][j] == n) {
					s2 = j;
				}
			}
		} 
		if (s1 > s2) {
			return num1 + s1 - s2;
		}else{
			return num1 + s2 - s1;
		}
		
	}
	/**
	 * 按照  题目要求  正向  反向  给数组赋值 
	 * @param x
	 */
	static void voluation(int[][] x) {
		int len = 1;
		int dum = 0;
		while (len < x.length + 1) {
			if (len % 2 != 0) {
				for (int i = 0; i < x[len - 1].length; i++) {
					x[len - 1][i] = dum + 1;
					dum = (len - 1) * x[len - 1].length + i + 1;
				}
				len++;
			} else {
				for (int i = x[len - 1].length - 1; i >= 0; i--) {
					x[len - 1][i] = dum + 1;
					dum++;
				}
				len++;
			}
		}
	}
}
