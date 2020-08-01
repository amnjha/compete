package CODECHEF.LongChallenge.June2020;

import java.util.Scanner;

public class TTUPLE {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		while(T-->0){
			solve();
		}
	}

	private static void solve() {
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long p = sc.nextLong();
		long q = sc.nextLong();
		long r = sc.nextLong();

		long d1 = p - a;
		long d2 = q - b;
		long d3 = r - c;
		long ans;
		long m1 = 0;
		long m2 = 0;
		long m3 = 0;

		if (a == p && b == q && c == r) {
			ans = 0;
			System.out.println(ans);
			return;
		}

		int flag = 0;
		if (a == p) flag++;
		if (b == q) flag++;
		if (c == r) flag++;
		if (flag == 2) {
			ans = 1;
			System.out.println(ans);
			return;
		}
		if (d1 == d2 && d2 == d3) {
			ans = 1;
			System.out.println(ans);
			return;
		}
		if (d1 == d2 && d3 == 0) {
			ans = 1;
			System.out.println(ans);
			return;
		}
		if (d1 == d3 && d2 == 0) {
			ans = 1;
			System.out.println(ans);
			return;
		}
		if (d3 == d2 && d1 == 0) {
			ans = 1;
			System.out.println(ans);
			return;
		}

		boolean correct_1 = false;
		boolean correct_2 = false;
		boolean correct_3 = false;

		if (p == a) {
			m1 = 1;
			correct_1 = true;
		} else {
			if (a != 0) {
				if (p % a == 0) {
					correct_1 = true;
					m1 = p / a;
				}
			}
		}

		if (q == b) {
			m2 = 1;
			correct_2 = true;
		} else {
			if (b != 0) {
				if (q % b == 0) {
					correct_2 = true;
					m2 = q / b;
				}
			}
		}

		if (c == r) {
			m3 = 1;
			correct_3 = true;
		} else {
			if (c != 0) {
				if (r % c == 0) {
					correct_3 = true;
					m3 = r / c;
				}
			}
		}

		if (correct_1 && correct_2 && correct_3) {
			//for ans=1;
			if (m1 == m2 && m2 == m3) {
				ans = 1;
				System.out.println(ans);
				return;
			}
			if (m1 == m2 && m3 == 1) {
				ans = 1;
				System.out.println(ans);
				return;
			}
			if (m2 == m3 && m1 == 1) {
				ans = 1;
				System.out.println(ans);
				return;
			}
			if (m1 == m3 && m2 == 1) {
				ans = 1;
				System.out.println(ans);
				return;
			}
		}
		if (correct_1 && correct_2) {
			if (m1 == m2) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}
		if (correct_1 && correct_3) {
			if (m1 == m3) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}
		if (correct_3 && correct_2) {
			if (m3 == m2) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}
		if (b != 0) {
			if (multiplyThenAddAlt(a, b, c, p, q, r)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
			if (multiplyThenAddAlt(c, b, a, r, q, p)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}

		if (a != 0) {
			if (multiplyThenAddAlt(b, a, c, q, p, r)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
			if (multiplyThenAddAlt(c, a, b, r, p, q)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}
		if (c != 0) {
			if (multiplyThenAddAlt(a, c, b, p, r, q)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
			if (multiplyThenAddAlt(b, c, a, q, r, p)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}

		//if two numbers are matching after one addition->
		if (d1 == 0 || d2 == 0 || d3 == 0) {
			ans = 2;
			System.out.println(ans);
			return;
		}
		if (d1 == d2 && d1 != d3) {
			ans = 2;
			System.out.println(ans);
			return;
		}
		if (d1 == d3 && d1 != d2) {
			ans = 2;
			System.out.println(ans);
			return;
		}
		if (d3 == d2 && d3 != d1) {
			ans = 2;
			System.out.println(ans);
			return;
		}

		if (d1 + d2 == d3) {
			ans = 2;
			System.out.println(ans);
			return;
		}
		if (d1 + d3 == d2) {
			ans = 2;
			System.out.println(ans);
			return;
		}
		if (d3 + d2 == d1) {
			ans = 2;
			System.out.println(ans);
			return;
		}

		if (correct_1 && correct_2 && correct_3) {
			if (m1 * m2 == m3) {
				ans = 2;
				System.out.println(ans);
				return;
			}
			if (m3 * m2 == m1) {
				ans = 2;
				System.out.println(ans);
				return;
			}
			if (m1 * m3 == m2) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}

		if ((a - b) != 0 && (p - q) != 0) {
			if (addThenMultiply(a, b, c, p, q, r)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}
		if ((b - c) != 0 && (q - r) != 0) {
			if (addThenMultiply(b, c, a, q, r, p)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}
		if ((a - c) != 0 && (p - r) != 0) {
			if (addThenMultiply(a, c, b, p, r, q)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}

		if (a != b) {
			if (multiplyThenAdd(a, b, c, p, q, r)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}
		if (b != c) {
			if (multiplyThenAdd(b, c, a, q, r, p)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}
		if (a != c) {
			if (multiplyThenAdd(c, a, b, r, p, q)) {
				ans = 2;
				System.out.println(ans);
				return;
			}
		}

		ans = 3;
		System.out.println(ans);
		return;

	}

	static boolean addThenMultiply(long a, long b, long c, long p, long q, long r) {
		long y = (p - q) / (a - b);
		if ((p - q) % (a - b) != 0) return false;
		long x = p / y - a;
		if ((p % y) != 0) return false;
		if ((((c + x) * y) == r) || ((c + x) == r) || ((c * y) == r))
			return true;

		return false;
	}

	static boolean multiplyThenAdd(long a, long b, long c, long p, long q, long r) {
		long x = (p - q) / (a - b);
		if ((p - q) % (a - b) != 0) return false;
		long y = p - (a * x);

		if ((((c * x) + y) == r) || (c * x == r) || (c + y == r))
			return true;

		return false;
	}


	static boolean multiplyThenAddAlt(long a, long b, long c, long p, long q, long r) {

		if (q % b != 0) return false;
		long x = q / b;
		long y = r - c;
		if ((a * x == p) || a + y == p || (a * x) + y == p || (a + y) * x == p)
			return true;

		return false;
	}
}
