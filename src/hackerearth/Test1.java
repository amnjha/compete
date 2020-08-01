package hackerearth;

import java.util.Scanner;


class Shinchan {

	static final int MAX_K = 10000000;
	static int k, n;
	static int[] a;
	static boolean good[];

	static int countIncreasing(int n) {
		int cnt = 0;  // Initialize result

		int len = 1;

		// Traverse through the array
		for (int i = 0; i < n; ++i) {
			// System.err.println("i = "+i);

			int j;
			for (j = i; j < n - 1; j++) {
				// System.err.println("\tj = "+j);
				if (a[j + 1] > a[j]) {
					len++;
					// System.err.println("\t\tcnt = "+cnt);
					cnt += j + 1;
				} else
					break;
			}
			i = j;

		}

		// If last length is more than 1


		return cnt + n;
	}


	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);


		int T = in.nextInt();

		while (T-- > 0) {
			n = in.nextInt();
			a = new int[n];
			good = new boolean[n];

			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();

			}

			for (int i = 0; i < n; i++) {
				good[i] = (in.nextInt() == 0);
			}

			System.out.println(countIncreasing(n));


		}


	}

}