package CODECHEF.cookoff.april20;

import java.util.Scanner;

public class MATBREAK {
	private static final long MOD = 1000000000 + 7;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int T = scanner.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	private static void solve() {
		long n = scanner.nextInt();
		long a = scanner.nextInt();

		long ans = 0;
		long p = 0;
		int j = 1;
		for (int i = 1; i <= n; i++) {
			p = p + power(a, j);
			ans = a;
			a = (a * power(ans, j)) % MOD;
			j = j + 2;
		}
		p = p % MOD;

		System.out.println(p);

	}

	static long power(long x, long y) {
		long res = 1;
		x = x % MOD;

		if (x == 0) return 0; // In case x is divisible by p;

		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % MOD;

			// y must be even now
			// y = y / 2
			y = y >> 1;
			x = (x * x) % MOD;
		}
		return res;
	}
}
