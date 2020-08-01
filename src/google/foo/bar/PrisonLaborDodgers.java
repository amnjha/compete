package google.foo.bar;

import java.util.Arrays;

public class PrisonLaborDodgers {
	public static void main(String[] args) {
		int[] x = {14, 27, 1, 4, 2, 50, 3, 1};
		int[] y = {2, 4, -4, 3, 1, 1, 14, 27, 50};
		System.out.println(solution(x,y));
	}

	public static int solution(int[] x, int[] y) {
		Arrays.sort(x);
		Arrays.sort(y);

		int minSize = x.length;
		int largerArray = 1;
		if (x.length > y.length) {
			largerArray = 0;
			minSize = y.length;
		}

		for (int i = 0; i < minSize; i++) {
			if (x[i] != y[i]) {
				if (largerArray == 0)
					return x[i];
				else
					return y[i];
			}
		}

		if (largerArray == 0)
			return x[x.length - 1];
		else
			return y[y.length - 1];
	}
}
