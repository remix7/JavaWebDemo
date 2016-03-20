package cc.cynara.lanqiao._2015;

import java.util.Scanner;

/**
 * 10.37 小明希望用星号拼凑，打印出一个大X，他要求能够控制笔画的宽度和整个字的高度。 为了便于比对空格，所有的空白位置都以句点符来代替。
 * 要求输入两个整数m n，表示笔的宽度，X的高度。用空格分开(0<m<n, 3<n<1000, 保证n是奇数) 要求输出一个大X 例如，用户输入： 3 9

 * 
 * @author liutao-REMIX
 * 
 */
public class _2015_9 {
	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		int m = Integer.parseInt(str.split(" ")[0]);
		int n = Integer.parseInt(str.split(" ")[1]);
		result(m, n);

	}
	static void result(int m, int n) {
		if (n % 2 != 1)
			return;
		String s[][];
		int flag = 0;
		if (m % 2 == 0) {
			s = new String[n][(m / 2 + n / 2) * 2];
			// 左上四分之一
			for (int i = 0; i < n / 2 + 1; i++) {
				for (int j = 0; j < (m / 2 + n / 2); j++) {
					// 此处打.
					for (int j2 = 0; j2 < flag; j2++) {
						s[i][j2] = ".";
					}
					if (j >= m + flag) {
						s[i][j] = ".";
					}
				}
				for (int j2 = flag; j2 < m + flag; j2++) {
					// 此处打*
					s[i][j2] = "*";
				}
				flag++;
			}
			// 右上四分之一
			for (int i = 0; i < n / 2 + 1; i++) {
				for (int j = 0; j < (m / 2 + n / 2); j++) {
					s[i][j + (m / 2 + n / 2)] = s[i][(m / 2 + n / 2) - j - 1];
				}
			}
			// 下面整个部分
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < (m / 2 + n / 2) * 2; j++) {
					s[n / 2 + i + 1][j] = s[n / 2 - i - 1][j];
				}
			}
		} else {
			s = new String[n][(m / 2 + n / 2 + 1) * 2 - 1];
			// 左上四分之一
			for (int i = 0; i < n / 2 + 1; i++) {
				for (int j = 0; j < (m / 2 + n / 2) + 1; j++) {
					// 此处打.
					for (int j2 = 0; j2 <= flag; j2++) {
						s[i][j2] = ".";
					}
					if (j >= m + flag) {
						s[i][j] = ".";
					}
				}
				for (int j2 = flag; j2 < m + flag; j2++) {
					// 此处打*
					s[i][j2] = "*";
				}
				flag++;
			}
			// 右上四分之一
			for (int i = 0; i < n / 2 + 1; i++) {
				for (int j = 0; j < (m / 2 + n / 2); j++) {
					s[i][j + (m / 2 + n / 2) + 1] = s[i][(m / 2 + n / 2) - j
							- 1];
				}
			}
			// 下面整个部分
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < (m / 2 + n / 2) * 2 + 1; j++) {
					s[n / 2 + i + 1][j] = s[n / 2 - i - 1][j];
				}
			}
		}
		//打印数组
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}
	}
}
