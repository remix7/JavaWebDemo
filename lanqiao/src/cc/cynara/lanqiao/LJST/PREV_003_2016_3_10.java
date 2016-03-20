package cc.cynara.lanqiao.LJST;

import java.util.Scanner;

/**
问题描述
100 可以表示为带分数的形式：100 = 3 + 69258 / 714。
还可以表示为：100 = 82 + 3546 / 197。
注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
类似这样的带分数，100 有 11 种表示法。
输入格式
从标准输入读入一个正整数N (N<1000*1000)
输出格式
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
注意：不要求输出每个表示，只统计有多少表示法！
样例输入1
100
样例输出1
11
样例输入2
105
样例输出2
6
 * @author liutao-REMIX 
 *
 */
public class PREV_003_2016_3_10 {
	static int kinds=0;  
    static int a[]=new int[10];  
    static boolean vis[]=new boolean[10];//全排列避免重复  
    static int sum(int start,int end)  
    {  
        int sum=0;  
        for(int i=start;i<end;i++) sum=sum*10+a[i+1];  
        return sum;  
    }  
    static void check(int a[],int n,int num)  
    {  
        int begin=1,temp=num;  
        while((temp=temp/10)!=0) begin++;  
        for(int k=1;k<begin+1;k++)  
        {  
            int num1=sum(0,k);  
            if(num1>=num) return;//加快跳出  
            for(int j=k+(n-k)/2;j<n-1;j++)  
            {  
                int num2=sum(k,j);  
                int num3=sum(j,n-1);  
                if(num2>num3 && num2%num3==0 &&num==num1+num2/num3)  
                {  
//                  System.out.println(num+" = "+num1+"+"+num2+"/"+num3);  
                    kinds++;      
                }  
            }  
        }     
    }  
    static void dfs(int start,int n,int num)  
    {  
        if(start==n)  
        {  
            check(a,n,num);  
        }  
        else  
        {  
            for(int i=1;i<n;i++)//全排列  
            {  
                if(vis[i]) continue;  
                a[start]=i;  
                vis[i]=true;  
                dfs(start+1,n,num);  
                vis[i]=false;  
            }  
        }  
    }  
    public static void main(String[] args)  
    {  
        Scanner cin=new Scanner(System.in);  
        int num=cin.nextInt();  
        long start=System.currentTimeMillis();  
        dfs(1,10,num);  
        long end=System.currentTimeMillis();  
//      System.out.println(end-start);//运行时间  
        System.out.println(kinds);    
    }  
}
