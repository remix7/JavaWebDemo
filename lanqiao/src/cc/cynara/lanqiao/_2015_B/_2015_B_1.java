package cc.cynara.lanqiao._2015_B;

public class _2015_B_1 {
	public static void main(String[] args) {
		int n = 8;
		int [][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			a[i][0] = 1;
			a[i][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <i; j++) {
//				System.out.println("-");
				a[i][j] = a[i-1][j-1]+a[i-1][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <=i; j++) {
				System.out.print(String.format("%-5d", a[i][j]));
				
			}
			System.out.println();
		}
	}
}
		
