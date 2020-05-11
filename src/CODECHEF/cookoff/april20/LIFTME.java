package CODECHEF.cookoff.april20;

import java.util.Scanner;

public class LIFTME {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int T = scanner.nextInt();
		while (T-- > 0){
			solve();
		}
	}

	public static void solve(){
		int currentFloor = 0;
		int N = scanner.nextInt();
		int Q = scanner.nextInt();

		long c = 0;
		while(Q-- > 0){
			int f = scanner.nextInt();
			int d = scanner.nextInt();

			c+= Math.abs(f-currentFloor);
			c+=Math.abs(d-f);
			currentFloor = d;
		}

		System.out.println(c);
	}
}
