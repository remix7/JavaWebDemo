package cc.cynara.lanqiao._2015;

import java.text.DecimalFormat;

public class _2015_2 {
	public static void main(String[] args) {
		int count = 0;
		DecimalFormat decimalFormat = new DecimalFormat("###");//格式化设置  
		for (double i = 1; i < 10000; i++) {
			double s = i*i*i;
			String str = decimalFormat.format(s);
			String le = (int)i+"";
			
			if(i==Integer.parseInt(str.substring(str.length()-le.length()))){
//				System.out.println(le+"  "+str);
				System.out.println(str.substring(str.length()-le.length()));
				count++;
			}
		}
		System.out.println("----"+count);
	}
}
