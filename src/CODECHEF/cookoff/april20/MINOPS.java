package CODECHEF.cookoff.april20;

import java.util.Scanner;

public class MINOPS {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int T = scanner.nextInt();
		scanner.nextLine();
		while (T-- > 0) {
			solve();
		}
	}

	private static void solve() {
		String S1 = scanner.nextLine();
		String S2 = scanner.nextLine();

		int len = S1.length();
		int k = 0;
		int m[] = new int[len];
		for (int i = 0; i < len; i++) {
			if(S1.charAt(i)!=S2.charAt(i))
				m[k]++;
			else
				k++;
		}

		long l = 0;
		long steps = 0;
		for(int mv : m){
			if(mv!=0) {
				l += mv;
				steps++;
			}
		}

		boolean startPosSet = false;
		int startPos = 0;
		int endPos = 0;
		for (int i = 0; i < len; i++) {
			if(S1.charAt(i)!=S2.charAt(i)){
				if(startPos==0 && !startPosSet) {
					startPos = i;
					startPosSet = true;
				}
				endPos = i;
			}
		}

		System.out.println(Math.min(steps*l, ((endPos - startPos)+1)));
	}
}
