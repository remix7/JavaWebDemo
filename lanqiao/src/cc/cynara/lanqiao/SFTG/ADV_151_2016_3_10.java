package cc.cynara.lanqiao.SFTG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



/**
　金陵十三钗
　　本题难度：难
　　本题占分比例：5%
问题描述
　　在电影《金陵十三钗》中有十二个秦淮河的女人要自我牺牲代替十二个女学生去赴日本人的死亡宴会。为了不让日本人发现，自然需要一番乔装打扮。但由于天生材质的原因，每个人和每个人之间的相似度是不同的。由于我们这是编程题，因此情况就变成了金陵n钗。给出n个女人和n个学生的相似度矩阵，求她们之间的匹配所能获得的最大相似度。
　　所谓相似度矩阵是一个n*n的二维数组like[i][j]。其中i,j分别为女人的编号和学生的编号，皆从0到n-1编号。like[i][j]是一个0到100的整数值，表示第i个女人和第j个学生的相似度，值越大相似度越大，比如0表示完全不相似，100表示百分之百一样。每个女人都需要找一个自己代替的女学生。
　　最终要使两边一一配对，形成一个匹配。请编程找到一种匹配方案，使各对女人和女学生之间的相似度之和最大。
输入格式
　　第一行一个正整数n表示有n个秦淮河女人和n个女学生
　　接下来n行给出相似度，每行n个0到100的整数，依次对应二维矩阵的n行n列。
输出格式
　　仅一行，一个整数，表示可获得的最大相似度。
样例输入
4
97 91 68 14
8 33 27 92
36 32 98 53
73 7 17 82
样例输出
354
数据规模和约定
　　对于70%的数据，n<=10
　　对于100%的数据，n<=13
样例说明
　　最大相似度为91+92+98+73=354
 * @author liutao-REMIX 
 *
 */
public class ADV_151_2016_3_10 {
	static Object dp[][];
	static int irr[][];
	static int[] result;
	static int s = 0;
	static int NUM;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		irr = new int[n][n];
		
		NUM = n;
		int m = 1;
		for (int i = 0; i < n; i++) {
			m*=(n-i);
		}
		dp = new Object[m][n];
		result = new int[m];
		
		for (int i = 0; i < irr.length; i++) {
			for (int j = 0; j < irr[i].length; j++) {
				irr[i][j] = sc.nextInt();
			}
		}
		
		String str[] = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = i+"";
		}
		
		sort(Arrays.asList(str), new ArrayList());
		
		for (int i = 0; i < dp.length; i++) {
			int sum = 0;
			int flag = 0;
			for (int j = 0; j < dp[i].length; j++) {
				sum+=irr[flag][Integer.parseInt(String.valueOf(dp[i][j]))];
				flag++;
			}
			result[i] = sum;
		}
		Arrays.sort(result);
		System.out.println(result[result.length-1]);
	}
	private static void sort(List datas, List target) {  
        if (target.size() == NUM) {  
        	for (int i = 0; i < target.size(); i++) {
				dp[s][i] = target.get(i);
			}
        	s++;
            return;  
        }  
        for (int i = 0; i < datas.size(); i++) {  
            List newDatas = new ArrayList(datas);  
            List newTarget = new ArrayList(target);  
            newTarget.add(newDatas.get(i));  
            newDatas.remove(i);  
            sort(newDatas, newTarget);  
        }  
    }  
}
