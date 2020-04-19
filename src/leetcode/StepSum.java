package leetcode;

import java.util.Arrays;

public class StepSum {
	public int minStartValue(int[] nums) {
		int sum = 0;
		int minSum = nums[0];
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if(sum<minSum)
				minSum = sum;
		}
		if(minSum <= 0)
			return Math.abs(minSum) + 1;
		else
			return minSum;
	}
}
