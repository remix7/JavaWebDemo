package cc.cynara.lanqiao._2014;
/**
 猜字母
把abcd...s共19个字母组成的序列重复拼接106次，得到长度为2014的串。
接下来删除第1个字母（即开头的字母a），以及第3个，第5个等所有奇数位置的字母。
得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请写出该字母。
答案是一个小写字母，请通过浏览器提交答案。不要填写任何多余的内容。

 * @author liutao-REMIX 
 *
 */
public class _2014_3 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abcdefghijklmnopqrs");
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < 106; i++) {
			sb1.append(sb);
		}
		//1 2 5 7 i*2-1
		while(sb1.length()!=1){
			for (int i = 0; i <sb1.length(); i+=2) {
				sb1.setCharAt(i, '*');
			}
			for (int i = 0; i < sb1.length(); i++) {
				if(sb1.charAt(i)=='*'){
					sb1.deleteCharAt(i);
				}
			}
		}
		System.out.println(sb1);
	}
}
