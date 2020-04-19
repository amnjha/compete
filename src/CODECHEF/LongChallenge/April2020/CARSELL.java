package CODECHEF.LongChallenge.April2020;

import java.util.Arrays;
import java.util.Scanner;

public class CARSELL {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int T = scanner.nextInt();
		while (T-- > 0){
			solve();
		}
	}

	public static void solve(){
		int MOD = 1_000_000_000 + 7;
		int N = scanner.nextInt();
		int A[] = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt();
		}

		Arrays.sort(A);
		int L = 0;
		long P = 0;
		for(int i = A.length -1 ; i>=0 ; i--){
			int v = A[i] - L++;
			if(v < 0 )
				v =0;
			P = (P + v) % MOD;
		}

		System.out.println(P);
	}
}
