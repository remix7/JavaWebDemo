package cc.cynara.lanqiao._2014;
/**
标题：李白打酒
话说大诗人李白，一生好饮。幸好他从不开车。
一天，他提着酒壶，从家里出来，酒壶中有酒2斗。他边走边唱：
无事街上走，提壶去打酒。
逢店加一倍，遇花喝一斗。
这一路上，他一共遇到店5次，遇到花10次，已知最后一次遇到的是花，他正好把酒喝光了。 
请你计算李白遇到店和花的次序，可以把遇店记为a，遇花记为b。则：babaabbabbabbbb 就是合理的次序。像这样的答案一共有多少呢？请你计算出所有可能方案的个数（包含题目给出的）。
注意：通过浏览器提交答案。答案是个整数。不要书写任何多余的内容。


 * @author liutao-REMIX 
 *
 */
public class _2014_6 {
	static int num = 0;
	public static void main(String[] args) {
		result(2, 5, 8);
		System.out.println(num);
	}
//	x 酒 y 店 z 花
	static void result(int x,int y,int z){
		if(x==2&&y==0&&z==0){
			num++;
			return;
		}
		if(x<0||y<0||z<0){
			return;
		}
		//遇到花
		result(x-1, y, z-1);
		//遇到店
		result(x*2, y-1, z);
	}
}
