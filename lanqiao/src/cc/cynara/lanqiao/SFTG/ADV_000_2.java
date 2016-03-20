package cc.cynara.lanqiao.SFTG;

import java.util.Scanner;

/**
 * 多重背包问题
有N种物品和一个容量为V的背包。第i种物品最多有n[i]件可用，每件费用是c[i]，价值是w[i]。
求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * @author liutao-REMIX 
 *
 */
public class ADV_000_2 {
	static int v ;//背包的总容量
	static int n ;//可容纳的件数
	static int c[] ;//物品的重量
	static int w[] ;//物品的价值
	static int f[] ;
	static int amount[];  //每个物品的数量
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		v = sc.nextInt();
		c = new int[n];
		w = new int[n];
		f = new int[v+1];
		amount = new int[n]; 
		for (int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
			w[i] = sc.nextInt();
			amount[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if(c[i]>v){
				c[i] = 0;
				w[i] = 0;
			}
			MultiplePack(c[i], w[i], amount[i]);
			
		}
		System.out.println(f[v]);
	}
	//多重背包
	static void MultiplePack(int c,int w,int amount){
		 if (c*amount>=v){
			 completePack(c,w);
	        return;
		 }
	    int k=1;
	    while(k<n){
	    	zeroOnePack(k*c,k*w);
	        amount=amount-k;
	        k=k*2;
	    }
	    zeroOnePack(amount*c,amount*w);
	}
	//完全背包
	static void completePack(int c,int w){
		for (int i = c; i <= v; i++) {
			f[i] = Math.max(f[i], f[i-c]+w);
		}
	}
	//01背包
	static void zeroOnePack(int c,int w){
		for (int i = v; i >= c; i--) {
			f[i] = Math.max(f[i], f[i-c]+w);
		}
	}
}
