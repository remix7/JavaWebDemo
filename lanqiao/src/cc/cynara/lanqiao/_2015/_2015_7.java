package cc.cynara.lanqiao._2015;
/**
加法变乘法
我们都知道：1+2+3+ ... + 49 = 1225
现在要求你把其中两个不相邻的加号变成乘号，使得结果为2015
比如：
1+2+3+...+10*11+12+...+27*28+29+...+49 = 2015
就是符合要求的答案。
请你寻找另外一个可能的答案，并把位置靠前的那个乘号左边的数字提交（对于示例，就是提交10）。
注意：需要你提交的是一个整数，不要填写任何多余的内容。
10--27
16--24
 * @author liutao-REMIX 
 *
 */
public class _2015_7 {
	public static void main(String[] args) {
		int[] arr = new int[49];
		for (int i = 1; i < 50; i++) {
			arr[i-1]=i;
		}
		int le = arr.length;
		int flag = 0;
		int Xflag = 2;
		int s = 0;
		for (int j = 0; j < arr.length; j++) {
			le=arr.length;
			Xflag = flag+2;
			while(le>0){
				s = 0;
				if(Xflag<arr.length-1&&flag<arr.length-1){
					s = arr[flag]*arr[flag+1]+arr[Xflag]*arr[Xflag+1];
					for (int i = 0; i < arr.length; i++) {
						if(i!=flag&&i!=flag+1&&i!=Xflag&&i!=Xflag+1){
							s += arr[i];
						}
					}
					if(s==2015){
						System.out.println(arr[flag]+"----"+arr[Xflag]);
					}
				}
				Xflag++;
				le--;
			}
			flag++;
		}
	}
}
