package cc.cynara.lanqiao.SFTG;

import java.util.Scanner;
import java.util.Vector;

/**http://blog.chinaunix.net/uid-22663647-id-1771843.html
 问题描述
　　给n个有序整数对ai bi，你需要选择一些整数对 使得所有你选定的数的ai+bi的和最大。并且要求你选定的数对的ai之和非负，bi之和非负。
输入格式
　　输入的第一行为n，数对的个数
　　以下n行每行两个整数 ai bi
输出格式
　　输出你选定的数对的ai+bi之和
	样例输入
	5
	-403 -625
	-847 901
	-624 -708
	-293 413
	886 709
	样例输出
	1715
	把每一行的值相加   然后再全部相加  再看其中几个相加的值是不是最大
 * @author liutao-REMIX 
 *
 */
public class ADV_200_2016_3_10 {
	static Scanner sc = new Scanner(System.in);
	static int n = sc.nextInt();
	static int [][] nums = new int[n][2];
	static int count[] = new int[nums.length];
	static int sum = 0;
	public static void main(String[] args) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				nums[i][j] = sc.nextInt();
			}
		}
		result();
	}
	static void result(){
		for (int i = 0; i < nums.length; i++) {
			count[i] = nums[i][0]+nums[i][1];
		}
		Vector<Integer> v = new Vector<Integer>();
		for (int i = 0; i < count.length; i++) {
			if(count[i]>0){
				sum+=count[i];
				v.add(i);
			}
		}
		System.out.println(sum);
		s(v);
	}
	/**
	 * @param v
	 */
	static void s(Vector<Integer> v){
		//判断 ai是否大于0
		int ai = 0;
		int bi = 0;
		for (int i = 0; i < v.size(); i++) {
			ai +=nums[v.get(i)][0];
			bi +=nums[v.get(i)][1];
			
		}
		if(ai>0&&bi>0){
			System.out.println(ai+bi);
		}else{
			for (int i = 0; i < v.size(); i++) {
				if(nums[v.get(i)][0]<0){
					v.remove(i);
					s(v);
				}
				
			}
		}
	}
}
