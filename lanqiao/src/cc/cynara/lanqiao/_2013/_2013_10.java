package cc.cynara.lanqiao._2013;

import java.util.Scanner;

/**
 * 
 * @author liutao-REMIX 
 *
 */
public class _2013_10 {
	private static int n;
	private static int m;
	private static int min = 100;
	private static int gezi[][];

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		m = cin.nextInt();
		n = cin.nextInt();
		gezi = new int[n][m];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				gezi[i][j] = cin.nextInt();
				sum += gezi[i][j];
			}
		}
		cal(0, 0, sum / 2, 0, new int[n][m]);
		System.out.println(min);
	}
	private static Boolean cal(int nn, int mm, int s, int c, int ed[][]) {	
		if (s == 0) {
			if (c < min)
				min = c;
			return true;
		}
		if (s < 0)
			return false;
		if (mm < m && nn < n && mm >= 0 && nn >= 0) {
			if (ed[nn][mm] == 0) {
				s -= gezi[nn][mm];
				ed[nn][mm] = 1;
				c++;
				cal(nn + 1, mm, s, c, ed);
				cal(nn - 1, mm, s, c, ed);
				cal(nn, mm + 1, s, c, ed);
				cal(nn, mm - 1, s, c, ed);
				ed[nn][mm] = 0;
			}
		}
		return false;
	}
//	public static void main(String[] args) {
//		String str = new Scanner(System.in).nextLine();
//		int x = Integer.parseInt(str.split(" ")[0]);
//		int y = Integer.parseInt(str.split(" ")[1]);
//		System.out.println(result(x, y));
//		
//	}
//
//	public static int result(int x, int y) {
//		int arr[][] = new int[x][y];
//		int count = 0,sum = 0; 
//		//键盘输入给数组赋值
//		for (int i = 0; i < arr.length; i++) {
//			String str1 = new Scanner(System.in).nextLine();
//			for (int j = 0; j < arr[i].length; j++) {
//				arr[i][j] = Integer.parseInt(str1.split(" ")[j]);
//				sum+=arr[i][j];
//			}
//		}
//		//判断切割一个格子的情况
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				if(arr[i][j]==sum-arr[i][j]){
//					count++;
//				}
//			}
//		}
//		//判断切割两个格子的情况 分为  00+01 01+02  0(n-1)+0n   00+10 10+20 (n-1)0+n0
////		int s = 0;
////		for (int i = 0; i < arr.length; i++) {
////			int j =0;
////			System.out.println(arr[i][j]+" + "+arr[i][++j] +"---"+arr[s][j]+" + "+arr[s][++j]);
////			j++;
////			s++;
////		}
//		
//		
//		return count;
//	}
}
