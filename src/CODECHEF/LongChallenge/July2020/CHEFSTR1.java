package CODECHEF.LongChallenge.July2020;

import java.util.Scanner;

class CHEFSTR1 {
    private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int T = scanner.nextInt();

		while (T-- > 0) {
			solve();
		}
	}

	private static void solve(){
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i + 1] > a[i])
                res += Math.abs(a[i + 1] - a[i] - 1);
            else  if (a[i + 1] == a[i])
                continue;
            else
                res = res + Math.abs(a[i + 1] - a[i]) - 1;
        }
        System.out.println(res);
    }
}