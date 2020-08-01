package CODECHEF.LongChallenge.July2020;

import java.util.*;

public class EXPREP {

	private static final Scanner scanner = new Scanner(System.in);
	private static List<Long> weights = new ArrayList<>();

	private static long MOD = 998244353;

	public static void main(String[] args) {
		int T;
		T = scanner.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	private static void solve() {
		String s;
		scanner.nextLine();
		s = scanner.nextLine();
		for (int i = 0; i < 26; i++) {
			long x = scanner.nextLong();
			weights.add(x);
		}
		solveExpression(s);
		weights.clear();
	}

	private static void solveExpression(String s) {
		int n = s.length();
		Map<String, Pair<Long, Long>> substrings = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i + 1; j++) {
				String ss = s.substring(i, i+j);
				Pair<Long, Long> pair = substrings.get(ss);
				if (pair == null) {
					substrings.put(ss, new Pair<>(1l, 0l));
				} else {
					pair.key++;
				}
			}
		}

		long numer = 0;
		long denom = (n * (n + 1)) / 2;
		for (Map.Entry<String, Pair<Long, Long>> p : substrings.entrySet()) {
			p.getValue().value = power(p.getKey());
			numer += (p.getValue().key * p.getValue().value);
		}
		long qinv = modInverse(denom);
		long ans = ((numer % MOD) * (qinv % MOD)) % MOD;
		System.out.println(ans);
	}

	static long pwr(long x, long y) {
		if (y == 0) return 1;
		long p = pwr(x, y / 2) % MOD;
		p = (p * p) % MOD;
		return (y % 2 == 0) ? p : (x * p) % MOD;
	}

	static long GCD(long a, long b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	static long modInverse(long a) {
		long g = GCD(a, MOD);
		if (g != 1)
			return 0;
		return pwr(a, MOD - 2);
	}

	static long power(String s) {
		List<String> pre = new ArrayList<>();
		List<String> validpre = new ArrayList<>();
		String abc = "";
		for (int i = 0; i < s.length(); i++) {
			abc += s.charAt(i);
			pre.add(abc);
		}
		for (String ss : pre) {
			int times = s.length() / ss.length();
			String tmp = ss;
			for (int t = 1; t < times; t++)
				tmp += ss;

			if (s.length() == tmp.length()) {
				if (s == tmp) validpre.add(ss);
			} else {
				int diff = s.length() % tmp.length();
				tmp += pre.get(diff - 1);
				if (s == tmp) validpre.add(ss);
			}
		}

		long total = 0;
		for (String ss : validpre) {
			for (char c : ss.toCharArray()) {
				total += weights.get(c - 'a');
			}
		}
		return total;
	}

	static class Pair<K, V> {
		K key;
		V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
