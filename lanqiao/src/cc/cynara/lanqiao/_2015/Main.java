package cc.cynara.lanqiao._2015;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
//		String arr[] = new String[a];
		Vector<String> v = new Vector<String>();
		int flag = 1;
		for (int i = 0; i < a; i++) {
			String str = new Scanner(System.in).nextLine();
			if("NEW".equals(str)){
				v.add(flag+"");
				flag++;
			}else if("Delete".equals(str.split(" ")[0])){
				for (int j = 0; j < v.size(); j++) {
					if(Integer.parseInt(v.elementAt(v.size()-1))<Integer.parseInt(str.split(" ")[1])){
						v.add("Failed");
					}else{
//						v.remove(Integer.parseInt(str.split(" ")[1])-1);
						v.add("Successful");
						if(flag!=1){
							flag--;
						}
					}
				}
			}
		}
		for(String st:v){
			System.out.println(st);
		}
	}
}

//数列排序
//Scanner s = new Scanner(System.in);
//int  i= s.nextInt();
//int arr[] = new int[i];
//String str = new Scanner(System.in).nextLine();
//for (int j = 0; j < arr.length; j++) {
//	arr[j] = Integer.parseInt(str.split(" ")[j]);
//}
//int flag = 0;
//for (int x = 0; x < arr.length; x++) {
//	for (int j = 1; j < arr.length; j++) {
//		if(arr[j]<arr[j-1]){
//			flag = arr[j];
//			arr[j] = arr[j-1];
//			arr[j-1] = flag;
//			
//		}
//	}
//}
//for (int j = 0; j < arr.length; j++) {
//	System.out.print(arr[j]+" ");
//}

//斐波拉切import java.util.Scanner;
//Scanner s = new Scanner(System.in);
//int  i= s.nextInt();
//int f1 = 1;
//int f2 = 1;
//for (int j = 3; j < i; j+=2) {
//	f1 = (f1+f2)%10007;
//	f2 = (f1+f2)%10007;
//}
//if(i%2!=0){
//	System.out.println(f1);
//}else{
//	System.out.println(f2);
//}

//序列求和
//Scanner s = new Scanner(System.in);
//long num = s.nextLong();
//long sum = (1+num)*num/2;
//System.out.println(sum);
//圆的面积
//Scanner s = new Scanner(System.in);
//DecimalFormat df = new DecimalFormat("####.0000000");
//int r = s.nextInt();
//System.out.println(df.format(r*r*Math.PI));