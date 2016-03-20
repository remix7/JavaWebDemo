package cc.cynara.lanqiao._2015;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 无穷分数 无穷的分数，有时会趋向于固定的数字。 请计算【图1.jpg】所示的无穷分数，要求四舍五入，精确到小数点后5位，小数位不足的补0。
 * 0.58198
 * @author liutao-REMIX
 * 
 */
public class _2015_3 {
	static double a = 0;
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int x = i;
			double t = x+1;
			result(x, t);
		}
	}
	static void result(int n,double t){
		if(n>=1){
	    	   a=n+(n+1)/t;
	    	   n--;
	    	   result(n,a);
	    	}else if(n==0){
	    		DecimalFormat df = new DecimalFormat("####.#####");
	    		
	    		System.out.println(df.format(1.0/a));
	    		
	    	}
	    	
	}
}
	
