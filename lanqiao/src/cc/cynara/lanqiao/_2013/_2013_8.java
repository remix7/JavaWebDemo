package cc.cynara.lanqiao._2013;

import java.util.*;

public class _2013_8 {
	static void Decphoto(int n) {
		int row = 0, col = 0, i = 0, j = 0, center = 0;
		int space = 0, num_s = 0, t = 0;

		row = col = 4 * (n - 1) + 9; // n层时，数组大小
		int[][] arr = new int[row][col]; // 开辟一维

		center = (row - 1) / 2; // 数组最中部那点坐标
		for (i = 0; i < row; ++i)
			// 全部初始化为'.'
			for (j = 0; j < col; ++j)
				arr[i][j] = '.';
		for (i = center - 1; i <= center; ++i) // 摆放中心十字图
		{
			arr[center][i] = '$';
			arr[i][center] = '$';
		}
		space = center; // 摆放$时，前面跳过个数space
		t = num_s = 1; // 需要连续摆放num_s个$
		// （A区域），（C区域）
		for (i = center - 2; i >= 0; i -= 2) // 摆放上面到中心和左边到中心'$'型
		{ // 这里从中心往外围摆放$
			for (j = space; t > 0; ++j) {
				arr[i][j] = '$';
				arr[j][i] = '$';
				--t;
			}
			space -= 2; // 注意观察规律
			t = num_s += 2;
		}
		// （B区域）
		for (i = 1; i < center - 1; i += 2)
			// 摆放中上对角线
			arr[i][i + 1] = '$';
		for (i = 2; i < center; i += 2)
			// 摆放正对角线
			arr[i][i] = '$';
		for (i = 2; i < center - 1; i += 2)
			// 摆放中下对角线
			arr[i][i - 1] = '$';
		// 至此，左上角的图案全部摆放完毕（然后通过对称性...）
		// （对称性 对折图形）
		for (i = 0; i < (row + 1) / 2; ++i)
			// 沿对角线对折
			for (j = 0; j < (col + 1) / 2; ++j)
				arr[row - i - 1][col - j - 1] = arr[i][j];

		for (i = 0; i < (row + 1) / 2; ++i)
			// 沿列中线对折
			for (j = 0; j < (col + 1) / 2; ++j)
				arr[i][col - j - 1] = arr[i][j];

		for (i = 0; i < (row + 1) / 2; ++i)
			// 沿行中线对折
			for (j = 0; j < (col + 1) / 2; ++j)
				arr[row - i - 1][j] = arr[i][j];

		for (i = 0; i < row; ++i) // 打印十字图
		{
			for (j = 0; j < col; ++j)
				System.out.printf("%c", arr[i][j]);
			System.out.println();
		}
		return;
	}

	// 主函数
	public static void main(String args[]) {
		int n = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Decphoto(n);
	}
}