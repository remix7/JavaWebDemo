package cc.cynara.lanqiao._2014;

import java.util.Scanner;

/**
标题：兰顿蚂蚁
兰顿蚂蚁，是于1986年，由克里斯•兰顿提出来的，属于细胞自动机的一种。
平面上的正方形格子被填上黑色或白色。在其中一格正方形内有一只“蚂蚁”。
蚂蚁的头部朝向为：上下左右其中一方。
蚂蚁的移动规则十分简单：
若蚂蚁在黑格，右转90度，将该格改为白格，并向前移一格；
若蚂蚁在白格，左转90度，将该格改为黑格，并向前移一格。
规则虽然简单，蚂蚁的行为却十分复杂。刚刚开始时留下的路线都会有接近对称，像是会重复，但不论起始状态如何，蚂蚁经过漫长的混乱活动后，会开辟出一条规则的“高速公路”。
蚂蚁的路线是很难事先预测的。
你的任务是根据初始状态，用计算机模拟兰顿蚂蚁在第n步行走后所处的位置。
 * @author liutao-REMIX 
 *
 */
public class _2014_8 {
	static String str = new Scanner(System.in).nextLine();
	static int x = Integer.parseInt(str.split(" ")[0]);
	static int y = Integer.parseInt(str.split(" ")[1]);
	static int[][] arr = new int[x][y];
	public static void main(String[] args) {
		for (int i = 0; i < x; i++) {
			str = new Scanner(System.in).nextLine();
			for (int j = 0; j < y; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		str = new Scanner(System.in).nextLine();
		int xx = Integer.parseInt(str.substring(0,1));
		int yy = Integer.parseInt(str.substring(2,3));
		String xxx = str.substring(4,5);
		int yyy = Integer.parseInt(str.substring(6));
		//变换蚂蚁走的初始朝向
		if(arr[xx][yy]==0){
			arr[xx][yy] = 1;
			if("U".equals(xxx)){
				xxx = "L";
				yy++;
			}else if("D".equals(xxx)){
				xxx = "R";
				yy--;
			}else if("L".equals(xxx)){
				xxx = "D";
				xx++;
			}else{
				xxx = "U";
				xx--;
			}
		}else{
			arr[xx][yy]= 0 ;
			if("U".equals(xxx)){
				xxx = "R";
				yy++;
			}else if("D".equals(xxx)){
				xxx = "L";
				yy--;
			}else if("L".equals(xxx)){
				xxx = "U";
				xx--;
			}else{
				xxx = "D";
				xx++;
			}
		}
		method(xx, yy, xxx, yyy-1);
	}
	/**
	 * 
	 * @param xx  蚂蚁放在点的横坐标
	 * @param yy  蚂蚁放在点的纵坐标
	 * @param xxx UDLR  蚂蚁头的朝向
	 * @param yyy 蚂蚁要走的步数
	 */
	static void method(int xx,int yy,String xxx,int yyy){
		if(yyy==0){
			System.out.println(xx+" "+yy);
			return;
		}
		if(arr[xx][yy]==0){
			arr[xx][yy] = 1;
			if("U".equals(xxx)){
				xxx = "L";
				method(xx, yy-1, xxx, yyy-1);
			}else if("D".equals(xxx)){
				xxx  = "R";
				method(xx, yy+1, xxx, yyy-1);
			}else if("L".equals(xxx)){
				xxx = "D";
				method(xx+1, yy, xxx, yyy-1);
			}else{
				xxx = "U";
				method(xx-1, yy, xxx, yyy-1);
			}
		}else{
			arr[xx][yy] = 0;
			if("U".equals(xxx)){
				xxx = "R";
				method(xx, yy+1, xxx, yyy-1);
			}else if("D".equals(xxx)){
				xxx  = "L";
				method(xx, yy-1, xxx, yyy-1);
			}else if("L".equals(xxx)){
				xxx = "U";
				method(xx-1, yy, xxx, yyy-1);
			}else{
				xxx = "D";
				method(xx+1, yy, xxx, yyy-1);
			}
		}
	}
}
