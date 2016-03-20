package cc.cynara.lanqiao._2015_B;

import java.util.Scanner;

public class _2015_B_6 {
	public static void main(String[] args) {
		method1();
		// String str = new Scanner(System.in).nextLine();
		// int num = Integer.parseInt(str);

	}

	public static void method2(int num) {

	}

	private static void method1() {
		double count = 0;
		for (double i = 2; i < 30; i++) {
			for (double j = 2; j < 30; j++) {
				for (double j2 = 2; j2 < 30; j2++) {
					for (double k = 2; k < 30; k++) {
						count = ((i * j * j2 * k) / i + (i * j * j2 * k) / j
								+ (i * j * j2 * k) / j2 + (i * j * j2 * k) / k)
								/ (i * j * j2 * k);
						if (count == 1 && i != j && i != j2 && i != k
								&& j != j2 && j != k && j2 != k && i < j
								&& j < j2 && j2 < k) {
							System.out.println("1/" + (int) i + " 1/" + (int) j
									+ " 1/" + (int) j2 + " 1/" + (int) k);
						}
					}
				}
			}
		}
	}
}
