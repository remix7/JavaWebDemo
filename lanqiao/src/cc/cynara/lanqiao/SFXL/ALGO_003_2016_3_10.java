package cc.cynara.lanqiao.SFXL;

import java.util.Scanner;
import java.util.Vector;

/**
 问题描述
如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好数。求L位K进制数中K好数的数目。例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。由于这个数目很大，请你输出它对1000000007取模后的值。
输入格式
输入包含两个正整数，K和L。
输出格式
输出一个整数，表示答案对1000000007取模后的值。
样例输入
4 2
样例输出
7
数据规模与约定
对于30%的数据，K^L <= 10^6；
对于50%的数据，K <= 16， L <= 10；
对于100%的数据，1 <= K,L <= 100。
 * @author liutao-REMIX 
 *
 */
public class ALGO_003_2016_3_10 {
	static long dp[][] = new long[105][105];
	static int mod = 1000000007;
	static Vector<String> v = new Vector<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int l = sc.nextInt();
		result(k, l);
		
	}
	static void result(int k,int l){
		for(int i = 0; i<k; i++)  
	        dp[1][i] = 1;  
	    for(int i = 2; i<=l; i++)  
	        for(int j = 0; j<k; j++)  
	            for(int x = 0; x<k; x++)  
	                if(x!=j-1&&x!=j+1)//根据题意，本位的数字与前面的数字是不能相邻的  
	                {  
	                    dp[i][j]+=dp[i-1][x];  
	                    dp[i][j]%=mod;  
	                }  
	    long sum = 0;  
	    for(int i = 1; i<k; i++)  
	    {  
	        sum+=dp[l][i];  
	        sum%=mod;  
	    }  
	    System.out.println(sum%mod);
	}
}
