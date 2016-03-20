package cc.cynara.lanqiao._2014;

import java.util.Scanner;

/**
 * 地宫取宝 14.57--- X 国王有一个地宫宝库。是 n x m 个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。
 * 地宫的入口在左上角，出口在右下角。 小明被带到地宫的入口，国王要求他只能向右或向下行走。
 * 走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。
 * 当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。 请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。
 * 【数据格式】 输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12) 接下来有 n 行数据，每行有 m 个整数 Ci
 * (0<=Ci<=12)代表这个格子上的宝物的价值 要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对 1000000007
 * 取模的结果。
 * 
 * @author liutao-REMIX
 * 
 */
public class _2014_9 {
	static String str = new Scanner(System.in).nextLine();
	static int a = Integer.parseInt(str.split(" ")[0]);//数组的行数
	static int b = Integer.parseInt(str.split(" ")[1]);//数组的列数
	static int k = Integer.parseInt(str.split(" ")[2]);//宝贝的个数
	public static void main(String[] args) {
		
		String [][] arr = new String[a][b];
		//K定义为一个一位数组
		StringBuffer sbK = new StringBuffer();
		
		for (int i = 0; i < arr.length; i++) {
			str = new Scanner(System.in).nextLine();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = str.split(" ")[j];
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	static void result(String[][] arr,int k){
		
	}
}
