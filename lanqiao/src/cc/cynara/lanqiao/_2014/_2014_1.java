package cc.cynara.lanqiao._2014;
/**
标题：猜年龄
小明带两个妹妹参加元宵灯会。别人问她们多大了，她们调皮地说：“我们俩的年龄之积是年龄之和的6倍”。小明又补充说：“她们可不是双胞胎，年龄差肯定也不超过8岁啊。”
请你写出：小明的较小的妹妹的年龄。
注意： 只写一个人的年龄数字，请通过浏览器提交答案。不要书写任何多余的内容。

 * @author liutao-REMIX 
 *
 */
public class _2014_1 {
	public static void main(String[] args) {
		for (double i = 1; i < 100; i++) {
			for (double j = 1; j < 100; j++) {
				if((i*j)/(i+j)==6.0&&i>j&&i-j<=8){
//					System.out.println(i+" "+j+" *:"+i*j +" +:"+(i+j));
					System.out.println(j);
				}
			}
		}
	}
}
