package cc.cynara.lanqiao.SFTG;

import java.util.Scanner;

/**
设计复数库，实现基本的复数加减乘除运算。
　　输入时只需分别键入实部和虚部，以空格分割，两个复数之间用运算符分隔；输出时按a+bi的格式在屏幕上打印结果。参加样例输入和样例输出。
　　注意考虑特殊情况，无法计算时输出字符串"error"。
样例输入
2 4 * -3 2
样例输出
-14-8i
样例输入
3 -2 + -1 3
样例输出
2+1i
 * @author liutao-REMIX 
 *
 */
public class ADV_120_2016_3_10 {
	public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner in=new Scanner(System.in);  
        int a=in.nextInt();  
        int b=in.nextInt();  
        char ch=in.next().charAt(0);  
        int c=in.nextInt();  
        int d=in.nextInt();  
        if(ch=='+')  
            sum(a,b,c,d);  
        else if(ch=='-')  
            sub(a,b,c,d);  
        else if(ch=='*')  
            mul(a,b,c,d);  
        else if(ch=='/')  
            div(a,b,c,d);  
    }  
      
    private static void sum(int a, int b, int c, int d) {  
        System.out.print(a+c);  
        if(b+d>=0)  
            System.out.print("+");  
        System.out.println((b+d)+"i");  
    }  
  
  
    private static void sub(int a, int b, int c, int d) {  
        System.out.print(a-c);  
        if(b-d>=0)  
            System.out.print("+");  
        System.out.println((b-d)+"i");  
  
    }  
  
    private static void mul(int a, int b, int c, int d) {  
        System.out.print(a*c-b*d);  
        if(a*d+b*c>=0)  
            System.out.print("+");  
        System.out.println((a*d+b*c)+"i");  
    }  
  
    private static void div(int a, int b, int c, int d) {  
        if(c==0&&d==0){  
            System.out.println("error");  
            return;  
        }  
        System.out.print((a*c+b*d)/(c*c+d*d));  
        if((b*c-a*d)/(c*c+d*d)>=0)  
            System.out.print("+");  
        System.out.println(((b*c-a*d)/(c*c+d*d))+"i");  
    }  
}
