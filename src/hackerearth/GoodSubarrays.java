package hackerearth;

import java.util.Scanner;

public class GoodSubarrays {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int T = scanner.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	private static void solve() {
		int N = scanner.nextInt();
		int A[] = new int[N];
		int unsorted_count = 0;
		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt();
			if (i != 0 && A[i] < A[i - 1])
				unsorted_count++;
		}

		boolean[] GB = new boolean[N];
		int goodCount = 0;
		for (int i = 0; i < N; i++) {
			int v = scanner.nextInt();
			if (v == 0) {
				GB[i] = true;
				goodCount++;
			}
		}

		int newN = N - unsorted_count;
		int MAX_SUBARRAYS = (newN * (newN + 1) / 2);
		if (goodCount == 0) {
			System.out.println(0);
		}

		if (unsorted_count == 0 && goodCount == A.length) {
			System.out.println(MAX_SUBARRAYS);
			return;
		}

		int unsorted = 0;
		int[] unsorted_numbers_until = new int[N];
		unsorted_numbers_until[N - 1] = unsorted;
		for (int i = N - 2; i >= 0; i--) {
			if (A[i] > A[i + 1])
				unsorted++;
			unsorted_numbers_until[i] = unsorted;
		}


		long subarrayCount = 0;//countIncreasing(A ,1, N);
		for (int i = 0; i < N-1; i++) {
			if (!GB[i]) {
				int remaining = (N - i - 1 - unsorted_numbers_until[i]);
				subarrayCount = subarrayCount - (remaining * (remaining + 1)) / 2;
			}
		}

		System.out.println(subarrayCount);
	}

	static int countIncreasing(int arr[],int start,  int n) {
		int cnt = 0;
		int len = 1;

		for (int i = start; i < n - 1; ++i) {
			if (arr[i + 1] > arr[i])
				len++;
			else {
				cnt += (((len - 1) * len) / 2);
				len = 1;
			}
		}

		if (len > 1)
			cnt += (((len - 1) * len) / 2);

		return cnt;
	}
}
