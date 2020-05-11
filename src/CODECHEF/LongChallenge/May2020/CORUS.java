package CODECHEF.LongChallenge.May2020;

import java.util.*;

public class CORUS {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int T = scanner.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	private static void solve() {
		int N = scanner.nextInt();
		int Q = scanner.nextInt();
		scanner.nextLine();

		String S = scanner.nextLine();
		Map<Character, Integer> freq = new HashMap<>();
		for(char c : S.toCharArray()){
			if(!freq.containsKey(c))
				freq.put(c, 1);
			else
				freq.put(c, freq.get(c)+1);
		}

		for (int i = 0; i < Q; i++) {
			int C = scanner.nextInt();
			int result = 0;
			for(Map.Entry<Character, Integer> entry : freq.entrySet()){
				int f = entry.getValue();
				if((f - C) > 0){
					result+=(f-C);
				}
			}

			System.out.println(result);
		}
	}
}
