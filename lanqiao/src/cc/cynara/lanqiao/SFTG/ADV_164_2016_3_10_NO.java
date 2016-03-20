package cc.cynara.lanqiao.SFTG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Vector;

/**
设第j件物品的价格为v[j]，重要度为w[j]，共选中了k件物品，编号依次为j_1，j_2，……，j_k，则所求的总和为：
　　v[j_1]*w[j_1]+v[j_2]*w[j_2]+ …+v[j_k]*w[j_k]。（其中*为乘号）
　　请你帮助金明设计一个满足要求的购物单。
输入格式
　　输入文件budget.in 的第1行，为两个正整数，用一个空格隔开：
　　N m
　　（其中N（<32000）表示总钱数，m（<60）为希望购买物品的个数。）
　　从第2行到第m+1行，第j行给出了编号为j-1的物品的基本数据，每行有3个非负整数
　　v p q
　　（其中v表示该物品的价格（v<10000），p表示该物品的重要度（1~5），q表示该物品是主件还是附件。如果q=0，表示该物品为主件，如果q>0，表示该物品为附件，q是所属主件的编号）
输出格式
　　输出文件budget.out只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（<200000）。
样例输入
1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0
样例输出
2200
 * @author liutao-REMIX 
 *
 */
public class ADV_164_2016_3_10_NO {
	static int n; //N（<32000）表示总钱数
	static int m; //m（<60）为希望购买物品的个数。
	static int irr[][];
	static int f[][]; //定义的dp
	static int c[] ;//物品的价值
	static int w[] ; //物品的重要度
	static int flag = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:\\budget.in")),"GBK"));
		String str = bf.readLine();
		n = Integer.parseInt(str.split(" ")[0]);
		m = Integer.parseInt(str.split(" ")[1]);
		irr = new int[m][3];
		for (int i = 0; i < irr.length; i++) {
			str = bf.readLine();
			for (int j = 0; j < irr[i].length; j++) {
				irr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		bf.close();
		c = new int[m];
		w = new int[m];
		f = new int[m+1][m+1];
		for (int i = 0; i < irr.length; i++) {
			if(irr[i][2]==0){
				c[i] = irr[i][0];
				w[i] = irr[i][1];
				for (int j = 0; j < irr.length; j++) {
					if(irr[j][2]==1&&j!=i){
						c[j] = irr[j][0];
						w[j] = irr[j][1];
					}
				}
			}else{
				continue;
			}
			for (int k = 0; k < m; k++) {
				zeroOnePack(c[k], w[k]);
			}
			flag++;
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("d:\\budget.out")));
		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < f[i].length; j++) {
				bw.write(f[i][j]+" ");
			}
			bw.write("\r\n");
		}
		bw.close();
		
	}
	static void zeroOnePack(int a,int l){
		int s = 0;
		for (int j = m; j >= l; j--) {
			f[flag][j] = Math.max(f[flag][j]+a, f[flag][j-l]+a);
			s = f[flag][j];
		}
		
	}
}
