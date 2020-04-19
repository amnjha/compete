package CODECHEF.LongChallenge.April2020;

import java.util.Scanner;

public class REBIT {
	private static Scanner scanner = new Scanner(System.in);
	private static int mod = 998_244_353;

	public static void main(String[] args) {
		int T = scanner.nextInt();
		scanner.nextLine();
		while (T-- > 0) {
			solve();
		}
	}

	private static void solve() {
		String input = scanner.nextLine();
		char[] inputChars = input.toCharArray();
		if (inputChars.length == 1) {
			long mI = modInverse(4);
			System.out.println(mI + " " + mI + " " + mI + " " + mI);
			return;
		}

		int hashCount = 0;
		int orCount = 0;
		int xorCount = 0;
		int andCount = 0;
		for (char c : inputChars) {
			if (c == '#')
				hashCount++;
			else if (c == '^')
				xorCount++;
			else if (c == '|')
				orCount++;
			else if (c == '&')
				andCount++;
		}

		long probNum_0 = getProbNumerator(0, andCount, orCount, xorCount);
		long probNum_1 = getProbNumerator(1, andCount, orCount, xorCount);
		long probNum_A = getProbNumerator(-1, andCount, orCount, xorCount);

		long prob_0 = (probNum_0 * modInverse(power(4, hashCount))) % mod;
		long prob_1 = (probNum_1 * modInverse(power(4, hashCount))) % mod;
		long prob_a_A = (probNum_A * modInverse(power(4, hashCount))) % mod;

		System.out.println(prob_0 + " " + prob_1 + " " + prob_a_A + " " + prob_a_A);

		/*Stack<Character> stack = new Stack<>();
		for(char c : inputChars){
			if(c!=')')
				stack.push(c);
			else{
				while (stack.isEmpty() || stack.peek() == '('){
					char v=stack.pop();
					if(c='#')
				}
			}
		}*/
	}

	private static long getProbNumerator(int n, int andCount, int orCount, int xorCount) {
		long val = 1;
		if (andCount != 0) {
			val = val * power(OPS.AND.getProb(n), andCount);
		} else if (orCount != 0) {
			val = val * power(OPS.OR.getProb(n), orCount);
		} else if (xorCount != 0) {
			val = val * power(OPS.XOR.getProb(n), xorCount);
		}
		return val;
	}

	static int power(int x, int y) {
		int res = 1;
		x = x % mod;

		if (x == 0) return 0; // In case x is divisible by p;

		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % mod;

			// y must be even now
			// y = y / 2
			y = y >> 1;
			x = (x * x) % mod;
		}
		return res;
	}

	static int modInverse(int a) {
		int m = mod;
		int m0 = m;
		int y = 0, x = 1;

		if (m == 1)
			return 0;

		while (a > 1) {
			int q = a / m;
			int t = m;
			m = a % m;
			a = t;
			t = y;
			y = x - q * y;
			x = t;
		}

		if (x < 0)
			x += m0;

		return x;
	}


	enum OPS {
		AND {
			@Override
			public int getProb(int val) {
				switch (val) {
					case 1:
						return 1;
					case 0:
						return 9;
					case -1:
						return 3;
				}
				return 0;
			}
		},
		OR {
			@Override
			public int getProb(int val) {
				switch (val) {
					case 1:
						return 9;
					case 0:
						return 1;
					case -1:
						return 3;
				}
				return 0;
			}
		},
		XOR {
			@Override
			public int getProb(int val) {
				return 4;
			}
		},
		;

		public int getProb(int val) {
			return 0;
		}

		public OPS getForChar(char op) {
			switch (op) {
				case '|':
					return OR;
				case '^':
					return XOR;
				case '&':
					return AND;
			}
			return null;
		}

	}
}
