package cc.cynara.lanqiao._2015_B;

public class _2015_B_2 {
	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		float j = 1;
		float count = 0;
		while(count<15.0){
			float s = i/j;
			j++;
			count+=s;
			sum++;
		}
		System.out.println(sum);
	}
}
