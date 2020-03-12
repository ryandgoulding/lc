package impl;

import api.ISolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution implements ISolution {

    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            final int compliment = target - nums[i];
            final Integer complimentIndex = seen.get(compliment);
            if (complimentIndex != null) {
                // we have found our pair
                return new int[] {i, complimentIndex};
            }
            seen.put(nums[i], i);
        }
        return null;
    }
}
