package cc.cynara.lanqiao._2015_B;

public class _2015_B_4 {
	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			int s1 = i * 1000000;
			for (int j = 1; j < 10; j++) {
				int s2 = j * 100000 + s1;
				for (int k = 1; k < 10; k++) {
					int s3 = k * 10000 + s2;
					for (int l = 1; l < 10; l++) {
						int s4 = l * 1000 + s3;
						for (int m = 1; m < 10; m++) {
							int s5 = m * 100 + s4;
							for (int n = 1; n < 10; n++) {
								int s6 = n * 10 + s5;
								for (int o = 1; o < 10; o++) {
									int s7 = o + s6;
									int sn = s1 + s2 + s3 + s4 + s5 + s6 + s7;
									if (sn < 10000000
											&& sn / 1000000 == sn % 10
											&& sn / 100000 % 10 == sn % 100 / 10 % 10
											&& sn / 10000 % 10 == sn % 1000 / 100 % 10
											&& sn / 1000 % 10 == sn / 1000000
											&& sn / 100000 % 10 == sn / 1000000
											&& sn / 10000 % 10 == sn / 1000000) {
										System.out.println("" + i + " " + j
												+ " " + k + " " + l + " "
												+ m + " " + n + " " + o);
										System.out.println(sn);
									}
									// int snum = s1 + s2 + s3 + s4 + s5 + s6 +
									// s7;
									// String str = snum + "";
									//									
									// if (str.length() == 7
									// && (str.charAt(0) == str.charAt(1))
									// && (str.charAt(0) == str.charAt(2))
									// && (str.charAt(0) == str.charAt(3))
									// && (str.charAt(0) == str.charAt(4))
									// && (str.charAt(0) == str.charAt(5))
									// && (str.charAt(0) == str.charAt(6))
									// ) {
									// System.out.println(str);
									// String sss = s7 + "";
									// System.out.println(s7);
									// }
								}
							}
						}
					}
				}
			}
		}

	}
}
