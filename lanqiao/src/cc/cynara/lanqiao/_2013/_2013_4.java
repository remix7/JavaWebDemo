package cc.cynara.lanqiao._2013;
/**
 标题: 第39级台阶
小明刚刚看完电影《第39级台阶》，离开电影院的时候，他数了数礼堂前的台阶数，恰好是39级!
站在台阶前，他突然又想着一个问题：
如果我每一步只能迈上1个或2个台阶。先迈左脚，然后左右交替，最后一步是迈右脚，也就是说一共要走偶数步。那么，上完39级台阶，有多少种不同的上法呢？
请你利用计算机的优势，帮助小明寻找答案。
要求提交的是一个整数。
注意：不要提交解答过程，或其它的辅助说明文字。

 * @author REMIX-7
 *
 */
public class _2013_4 {
//	static final int s = 39; //自定义的台阶数
//    static int len = 0, sum = 0;
//    static int count = 0;
//    static int step[] = new int[s];
//    static void compute(final int stair) {
//        if (stair < 0)
//            return;
//        //表示已经走完了
//        if (stair == 0) {
//            printSum();
//            sum++;
//            return;
//        }
//        //每次到下一步选择时都可以走1-2步
//        for (int i = 1; i <= 2; i++) {
//            step[len] = i;
//            len++;
//            //进行下一步的迭代，迭代完之后将每后加上的一步去掉，换成其它的步数(如从1换成2)
//            compute(stair - i);
//            len--;
//        }
//    }
// 
//    static void printSum() {
////    	System.out.println(len);
//    	if(len%2==0){
//    		count++;
//    	}
////        System.out.print("走法:");
////        for (int i = 0; i < len; i++)
////            System.out.print(step[i] + " ");
////        System.out.println();
//    }
// 
//    public static void main(String args[]) {
//        compute(s);
//        System.out.println("共有" + count + "种走法");
//    }
// 
	private static int count;  //step 使用的步数，范围0-39   tj 总过的台阶数，范围0-39 
    public static void main(String[] args) {  
        count = 0;  
        walkUp(0, 0);  
        System.out.println(count);  
    }  
    private static void walkUp(int step, int tj){  
        if(tj > 39){  
            return;  
        }  
        if(tj == 39){  
            if(step%2 == 0){  
                count++;  
            }  
            return;  
        }  
        walkUp(step+1, tj+1);  
        walkUp(step+1, tj+2);  
    }  
}
