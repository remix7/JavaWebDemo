package cc.cynara.lanqiao._2014;

import java.util.Scanner;
import java.util.Vector;


/**
标题：矩阵翻硬币
小明先把硬币摆成了一个 n 行 m 列的矩阵。
随后，小明对每一个硬币分别进行一次 Q 操作。
对第x行第y列的硬币进行 Q 操作的定义：将所有第 i*x 行，第 j*y 列的硬币进行翻转。
其中i和j为任意使操作可行的正整数，行号和列号都是从1开始。
当小明对所有硬币都进行了一次 Q 操作后，他发现了一个奇迹——所有硬币均为正面朝上。
小明想知道最开始有多少枚硬币是反面朝上的。于是，他向他的好朋友小M寻求帮助。
聪明的小M告诉小明，只需要对所有硬币再进行一次Q操作，即可恢复到最开始的状态。然而小明很懒，不愿意照做。于是小明希望你给出他更好的方法。帮他计算出答案。
【数据格式】
    输入数据包含一行，两个正整数 n m，含义见题目描述。
    输出一个正整数，表示最开始有多少枚硬币是反面朝上的。
【样例输入】
2 3
【样例输出】
1

 * @author liutao-REMIX 
 *
 */
public class _2014_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Vector<Integer> v = new Vector<Integer>();
		String str = new Scanner(System.in).nextLine();
		for (int i = 0; i < n; i++) {
			v.add(Integer.parseInt(str.split(" ")[i]));
		}
		
		for (int i = 0; i < m; i++) {
			str = new Scanner(System.in).nextLine();
			if("DEL".equals(str.split(" ")[0])){
				Integer flag = Integer.parseInt(str.split(" ")[1]);
				for (int j = 0; j < v.size(); j++) {
					if(v.get(j)==flag){
						v.remove(j);
					}
				}
			}else if("ADD".equals(str.split(" ")[0])){
				Integer flag = Integer.parseInt(str.split(" ")[1]);
				Integer flag_1 = Integer.parseInt(str.split(" ")[2]);
				for (int j = 0; j < v.size(); j++) {
					if(v.get(j)==flag){
						v.insertElementAt(flag_1, j);
						break;
					}
				}
			}
		}
		System.out.println(v.size());
		for (int i = 0; i < v.size(); i++) {
			System.out.print(v.get(i)+" ");
		}
	}
}
