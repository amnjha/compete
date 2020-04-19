package CODECHEF.LongChallenge.April2020;

import java.util.Scanner;

public class UNITGCD {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int T = scanner.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	private static void solve() {
		int N = scanner.nextInt();
		StringBuilder stringBuilder = new StringBuilder(((N==1)? N : N / 2) + "\n");
		if (N == 1) {
			stringBuilder.append("1 1").append("\n");
		} else if (N == 2) {
			stringBuilder.append("2 1 2").append("\n");
		} else {
			stringBuilder.append("3 1 2 3").append("\n");
			int i = 0;
			for (i = 4; i < N; i += 2) {
				stringBuilder.append(2).append(" ").append(i).append(" ").append(i + 1).append("\n");
			}
			if (i == N)
				stringBuilder.append(1).append(" ").append(i);
		}

		System.out.println(stringBuilder.toString());
	}
}
