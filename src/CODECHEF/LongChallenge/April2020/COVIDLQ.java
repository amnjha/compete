package CODECHEF.LongChallenge.April2020;

import java.util.Scanner;

public class COVIDLQ {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int T = scanner.nextInt();
		while (T-- > 0){
			solve();
		}
	}

	private static void solve(){
		int N = scanner.nextInt();
		int c = 6;
		boolean isFollowed = true;

		for (int i = 0; i < N; i++) {
			int A = scanner.nextInt();
			if(A == 1){
				if(c < 6)
					isFollowed = false;
				c = 0;
			}
			c++;
		}

		if(isFollowed)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
