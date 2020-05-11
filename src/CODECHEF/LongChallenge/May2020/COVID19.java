package CODECHEF.LongChallenge.May2020;

import java.util.Scanner;

public class COVID19 {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int T = scanner.nextInt();
		while (T-- > 0){
			solve();
		}
	}

	private static void solve(){
		int N = scanner.nextInt();
		int min = Integer.MAX_VALUE;
		int max = 0;
		int c = 1;

		int prev = scanner.nextInt();
		for (int i = 1; i < N; i++) {
			int k = scanner.nextInt();
			if((k - prev) <= 2)
				c++;
			else {
				if(c<min)
					min = c;
				if(c > max)
					max = c;

				c = 1;
			}
			prev = k;
		}

		if(c<min)
			min = c;
		if(c > max)
			max = c;

		if(min == Integer.MAX_VALUE)
			min = 0;
		System.out.println(min + " "  + max);
	}
}
