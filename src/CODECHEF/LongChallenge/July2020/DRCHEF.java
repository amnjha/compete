package CODECHEF.LongChallenge.July2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class DRCHEF {
	private static Scanner scanner = new Scanner(System.in);

	private static void solve() {

		int n = scanner.nextInt();
		long covidPatient = scanner.nextLong();
		List<Long> val = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			val.add(scanner.nextLong());
		}

		val.sort(Comparator.naturalOrder());

		int dexter = 0;
		int dd = 0;
		for (int i = 0; i < n; i++) {
			if (val.get(i) * 2 >= covidPatient) {
				dexter = i;
				break;
			}
		}
		for (int i = dexter; i < n; i++) {
			if (val.get(i) <= covidPatient) {
				covidPatient = val.get(i) + val.get(i);
				dd++;
			} else if (covidPatient < val.get(i)) {
				while (covidPatient < val.get(i)) {
					covidPatient += covidPatient;
					dd++;
				}
				covidPatient = val.get(i) + val.get(i);
				dd++;
			}
		}
		System.out.println(dd + dexter);

	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		while (t-- > 0) {
			solve();
		}
	}

}