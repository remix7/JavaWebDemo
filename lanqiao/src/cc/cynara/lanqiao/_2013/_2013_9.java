package cc.cynara.lanqiao._2013;

import java.util.Scanner;

public class _2013_9 {
	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		int num1 = Integer.parseInt(str.split(" ")[0]);
		int num2 = Integer.parseInt(str.split(" ")[1]);
		if(gcd(num1, num2)==1){
			System.out.println(count(num1, num2));
		}else{
			System.out.println("无解");
		}
	}
	static int gcd(int x,int y){
		if(y == 0 ) return x;
		else return gcd(y,x%y);
	}
	static int count(int x,int y){
		return x*y-x-y;
	}
}
