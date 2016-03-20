package cc.cynara.lanqiao._2015;
/**
奇妙的数字
小明发现了一个奇妙的数字。它的平方和立方正好把0~9的10个数字每个用且只用了一次。
你能猜出这个数字是多少吗？
请填写该数字，不要填写任何多余的内容。
平方是四位数  10-21
立方是六位数 18-31    
18
 * @author liutao-REMIX 
 *
 */
public class _2015_6 {
	public static void main(String[] args) {
		for (int i = 18; i < 22; i++) {
			System.out.println(""+i*i*i+" "+i*i*i*i);
		}
	}
}
