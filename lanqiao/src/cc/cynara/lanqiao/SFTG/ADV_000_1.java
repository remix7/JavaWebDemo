package cc.cynara.lanqiao.SFTG;

import java.util.Scanner;

/**
 * 完全背包问题
有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是c[i]，价值是w[i]。
求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * @author liutao-REMIX 
 *
 */
public class ADV_000_1 {
	static int v ;//背包的总容量
	static int n ;//可容纳的件数
	static int c[] ;//物品的重量
	static int w[] ;//物品的价值
	static int f[] ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		v = sc.nextInt();
		c = new int[n];
		w = new int[n];
		f = new int[v+1];
		for (int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if(c[i]>v){
				c[i] = 0;
				w[i] = 0;
			}
			zeroOnePack(c[i], w[i]);
		}
		System.out.println(f[v]);
	}
	static void zeroOnePack(int c,int w){
		for (int i = c; i <= v; i++) {
			f[i] = Math.max(f[i], f[i-c]+w);
		}
	}
}
