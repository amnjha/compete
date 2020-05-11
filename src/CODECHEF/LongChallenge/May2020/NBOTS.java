package CODECHEF.LongChallenge.May2020;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NBOTS {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//int T = scanner.nextInt();
		solve();
	}

	private static void solve() {
		int N = scanner.nextInt();
		int F = scanner.nextInt();

		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		int K = scanner.nextInt();

		Random random = new Random();
		List<String> dirs = Arrays.asList("L","U","R","D");

		for (int i = 0; i < K-1; i++) {
			int rc = random.nextInt(N);
			String lurd = dirs.get(random.nextInt(4));
			System.out.println(lurd + " " + rc);
		}
		/*int row = 0;
		int col = 0;
		for (int i = 0; i < K - 1; i++) {
			int p = F;
			row = i;
			col = i;
			System.out.println("U " + col);
			while (p > 0 && row < N && col < N) {
				if (arr[row][col] < p) {
					p = p - arr[row][col];
					arr[row++][col] = 0;
				} else {
					break;
				}
			}
		}

		boolean flag = true;
		row = 0;
		col = 0;
		while (flag) {
			System.out.println("L " + row);
			int p = F;
			while (p > 0 && row < N && col < N) {
				if (arr[row][col] < p) {
					p = p - arr[row][col];
					arr[row][col++] = 0;
				} else {
					break;
				}
			}

			if(col == N) {
				row++;
				col = 0;
			}

			if(row == N && col == N)
				flag = false;
		}
	*/
	}
}
