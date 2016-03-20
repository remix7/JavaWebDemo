package cc.cynara.lanqiao._2014;

/**
 * 写日志 写日志是程序的常见任务。现在要求在 t1.log, t2.log, t3.log
 * 三个文件间轮流写入日志。也就是说第一次写入t1.log，第二次写入t2.log，... 第四次仍然写入t1.log，如此反复。
 * 下面的代码模拟了这种轮流写入不同日志文件的逻辑。 public class A { private static int n = 1;
 * 
 * public static void write(String msg) { String filename = "t" + n + ".log"; n
 * = ____________; System.out.println("write to file: " + filename + " " + msg);
 * } } 请填写划线部分缺失的代码。通过浏览器提交答案。 注意：不要填写题面已有的内容，也不要填写任何说明、解释文字。
 * 
 * @author liutao-REMIX
 * 
 */
public class _2014_5 {
	private static int n = 1;

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			write("hah");
		}
	}

	public static void write(String msg) {
		String filename = "t" + n + ".log";
		n = n % 3 + 1;// 填空
		System.out.println("write to file: " + filename + " " + msg);
	}
}
