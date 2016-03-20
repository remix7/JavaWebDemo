package cc.cynara.lanqiao._2015;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
垒骰子13.34
赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。
经过长期观察，atm 发现了稳定骰子的奥秘：有些数字的面贴着会互相排斥！*
我们先来规范一下骰子：1 的对面是 4，2 的对面是 5，3 的对面是 6。
假设有 m 组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。 atm想计算一下有多少种不同的可能的垒骰子方式。
两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。
由于方案数可能过多，请输出模 10^9 + 7 的结果。
不要小看了 atm 的骰子数量哦～
「输入格式」
第一行两个整数 n m
n表示骰子数目
接下来 m 行，每行两个整数 a b ，表示 a 和 b 不能紧贴在一起。
「输出格式」
一行一个数，表示答案模 10^9 + 7 的结果。
「样例输入」
2 1
1 2
「样例输出」
544

 * @author liutao-REMIX 
 *
 */
public class _2015_10 {
	//定义一个6*6的矩阵
	static int[][] tz = new int[6][6];
	//骰子的对面  从1到6顺序
	static int [] dm = {0,4,5,6,1,2,3};
	static long s = 0;
	static Scanner sc = new Scanner(System.in);
	static int n = sc.nextInt();
	static int m = sc.nextInt();
	public static void main(String[] args) {
		//定义一个m行长的数组 存放互相排斥的情况
		int arr[][] = new int[m][2]; 
		//给数组赋值  其中的每一行代表一对互相排斥的情况
		for (int i = 0; i < arr.length; i++) {
			String str = new Scanner(System.in).nextLine();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		//模仿骰子的各个面对矩阵赋值
		for (int i = 0; i < tz.length; i++) {
			int flag=1;
			for (int j = 0; j < tz[i].length; j++) {
				tz[i][j] = flag;
				flag++;
			}
		}
		//互相排斥的点值为0
		for (int i = 0; i < arr.length; i++) {
			tz[arr[i][0]-1][arr[i][1]-1] = 0;
			tz[arr[i][1]-1][arr[i][0]-1] = 0;
		}
		System.out.println(result(arr,n));
	}
	/**
	 * 
	 * @param arr
	 * @param n
	 * @return b.remainder(b2).longValue();大数处理后
	 */
	static long result(int[][] arr,int n){
		if(n==1){
			return 0;
		}
		if(n==2){
			return ((36-2*(arr.length))*4*4)%(1000000000l+7);
		}
		for (int i = 0; i < tz.length; i++) {
			for (int j = 0; j < tz[i].length; j++) {
				if(tz[i][j]!=0){
					s +=count(dm[tz[i][j]]);
				}
			}
		}
		//大数处理相关
		BigInteger b =  new BigInteger(s+"");
		BigInteger b1 = new BigInteger(4+"");
		BigInteger b2 = new BigInteger(1000000007+"");
		//循环乘以四
		for (int i = 0; i < n; i++) {
			b = b.multiply(b1);
		}
		//取模  转换为long
		return b.remainder(b2).longValue();
	}
	//找最后一次的数量
	static int count(int s){
		int length = n;
		int c = 0;
		if(n<4){
			return sum(s);
		}else{
			while(length>3){
				for (int j = 0; j < tz[s-1].length; j++) {
					if(tz[s-1][j] != 0){
						c += sum(dm[tz[s-1][j]]);
					}
				}
				length--;
			}
		}
		return c;
	}
	//循环产生底面相同时的最上面的数量
	static int sum(int s){
		int co = 0;
		for (int j = 0; j < tz[s-1].length; j++) {
			if(tz[s-1][j] != 0){
				co++;
			}
		}
		return co;
	}
}
