package hackerearth;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	static long dp[][] = new long[505][505];
	static long arr[] = new long[505];
	static long[] pm = new long[1000100];
	static long[] indexx = new long[10000100];
	static Set<Long> s = new TreeSet<>();
	static long ans = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		prime();
		int n;
		int idx = 1;
		for (int i = 0; i < 505; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 2; i <= 1000000; i++) {
			if (pm[i] == 0) {
				indexx[i] = idx++;
				s.add((long) i);
			}

		}
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int lowerBound = lower_bound(a);
			arr[i] = indexx[lowerBound];
			ans += lowerBound - a;
		}
		long ans1 = solve(0, n - 1);
		System.out.println(ans + ans1);
	}

	private static int lower_bound(int a) {
		int val = -1;
		for (Long aLong : s) {
			val = Math.toIntExact(aLong);
			if (aLong >= a)
				return val;
		}
		return val;
	}

	private static long solve(int st, int en) {
		if (st > en)
			return 0;
		else if (st == en)
			return 1;
		else if (dp[st][en] != -1) {
			return dp[st][en];
		} else {
			long ret = 1 + solve(st + 1, en);
			for (int i = st + 1; i <= en; i++) {
				if (arr[i] == arr[st] + 1) {
					ret = Math.min(ret, solve(st + 1, i - 1) + solve(i, en));
				}
			}
			dp[st][en] = ret;
			return ret;
		}
	}

	private static void prime() {
		for (int i = 2; i <= 1000000; i++) {
			if (pm[i] == 0)
				for (int j = 2; j * i <= 1000000; j++) {
					pm[i * j] = 1;
				}
		}
	}
}