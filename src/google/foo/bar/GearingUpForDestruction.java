package google.foo.bar;

import java.util.Arrays;

public class GearingUpForDestruction {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{20, 50})));
	}

	public static int[] solution(int[] pegs) {
		int[] result = new int[2];

		int len = pegs.length;
		int sum = 0 - pegs[0];
		int internal_sum = 0;
		for (int i = 1; i < len - 1; i++) {
			if (i % 2 == 0) {
				internal_sum -= pegs[i];
			} else {
				internal_sum += pegs[i];
			}
		}
		internal_sum *= 2;

		double radius;
		if (len % 2 == 0) {
			sum = 2 * (sum + internal_sum + pegs[len - 1]);
			radius = sum / 3.0d;
			if(Math.ceil(radius) == Math.floor(radius)) {
				result[1] = 1;
				sum/=3;
			} else {
				result[1] = 3;
			}
		} else {
			sum = 2 * (sum + internal_sum - pegs[len - 1]);
			radius = sum;
			result[1] = 1;
		}
		result[0] = sum;

		if (radius < 2) {
			result[0] = -1;
			result[1] = -1;
		}

		double currentValue = radius;
		for (int i = 0; i < pegs.length - 1; i++) {
			double diff = pegs[i + 1] - pegs[i];
			double nextValue = diff - currentValue;

			if (currentValue < 1 || nextValue < 1)
				return new int[]{-1, -1};

			currentValue = nextValue;
		}

		return result;
	}
}
