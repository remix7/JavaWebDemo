package cc.cynara.lanqiao._2015_B;
/**
 3. 10301是个5位的素数。它有个特点，把数字倒过来还是它本身，具有这样特征的素数，我们称之为：回文素数。
10501
10601
11311
这些都是5位的回文素数。
请你计算一下，像这样的5位数的回文素数，一共有多少个？
请填写这个表示个数的整数，注意不要写任何其它多余的内容，比如说明或解释文字，也不要列出所有的回文素数。

 * @author REMIX-7
 *
 */
public class _2015_B_3 {
	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		for (int i = 10000; i <=99999; i++) {
			
			boolean b = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j==0){
					b = false;
					break;
				}
			}
			if(b){
				int n1 = i/10000;
				int n5 = i%10;
				int n2 = i/1000%10;
				int n4 = i/10%10;
				if(n1==n5&&n2==n4){
//					System.out.println(i);
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
}
