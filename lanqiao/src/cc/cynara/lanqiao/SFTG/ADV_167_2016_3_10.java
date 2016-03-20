package cc.cynara.lanqiao.SFTG;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;


/**
问题描述
　　"嘟嘟嘟嘟嘟嘟
　　喇叭响
　　我是汽车小司机
　　我是小司机
　　我为祖国运输忙
　　运输忙"
　　这是儿歌“快乐的小司机”。话说现在当司机光有红心不行，还要多拉快跑。多拉不是超载，是要让所载货物价值最大，特别是在当前油价日新月异的时候。司机所拉货物为散货，如大米、面粉、沙石、泥土......
　　现在知道了汽车核载重量为w，可供选择的物品的数量n。每个物品的重量为gi,价值为pi。求汽车可装载的最大价值。（n<10000,w<10000,0<gi<=100,0<=pi<=100)
输入格式
　　输入第一行为由空格分开的两个整数n w
　　第二行到第n+1行，每行有两个整数，由空格分开，分别表示gi和pi
输出格式
　　最大价值（保留一位小数）
样例输入
5 36
99 87
68 36
79 43
75 94
7 35
样例输出
71.3
解释：
先装第5号物品，得价值35，占用重量7
再装第4号物品，得价值36.346,占用重量29
最后保留一位小数，得71.3
 * @author liutao-REMIX 
 *
 */
public class ADV_167_2016_3_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int irr[][] = new int[n][2];
		double count = 0;
		for (int i = 0; i < irr.length; i++) {
			for (int j = 0; j < irr[i].length; j++) {
				irr[i][j] = sc.nextInt();
			}
		}
		double flags[] = new double[n];
		double flag[][] = new double[n][2];
		for (int i = 0; i < flag.length; i++) {
			flag[i][0] = ((double)irr[i][1]/(double)irr[i][0]);
			flag[i][1] = irr[i][0];
			flags[i] = flag[i][0];
		}
		Arrays.sort(flags);
		for (int i = flags.length-1; i > 0; i--) {
			for (int j = 0; j < flag.length; j++) {
				if(flags[i]==flag[j][0]&&flag[j][1]<=w&&w>=0){
					count+=flag[j][0]*flag[j][1];
					w = (int) (w-flag[j][1]);
				}else if(flags[i]==flag[j][0]&&flag[j][1]>w&&w>=0){
					count+=flag[j][0]*(w);
					w = 0;
				}
			}
		}
		DecimalFormat df = new DecimalFormat("#.#");
		System.out.println(df.format(count));
	}
}
