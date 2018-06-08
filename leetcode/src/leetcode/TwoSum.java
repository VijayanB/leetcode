package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int res[] = { 0, 1 };
		if (nums.length < 3)
			return res;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				res[0] = i;
				res[1] = map.get(diff);
				break;
			}
			map.put(nums[i], i);
		}
		return res;
	}

	public static void main(String[] args) {

	}
}
