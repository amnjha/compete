package CODECHEF.LongChallenge.June2020;

import java.util.Scanner;

public class EOEO {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		while (T-- > 0){
			System.out.println(solve());
		}
	}

	private static long solve(){
		long TS = sc.nextLong();

		while(TS % 2 == 0){
			TS/=2;
		}

		return TS/2;
	}
}
