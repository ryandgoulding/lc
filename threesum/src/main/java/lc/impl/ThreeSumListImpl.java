package lc.impl;

import lc.api.IThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A much faster implementation than ThreeSumSetImpl.  This solution thwarts an initial reorder, followed by proactively
 * skipping duplicates.
 */
public class ThreeSumListImpl implements IThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> matches = new ArrayList<>();

        if (nums.length < 3) {
            return matches;
        }

        Arrays.sort(nums);

        int l, r, sum;
        for (int i = 0; i < nums.length; i++) {
            l = i + 1;
            r = nums.length - 1;

            while (l<r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    matches.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; r--;
                    for(;l<r && l - 1 > 0 && nums[l] == nums[l-1]; l++);
                    for(;l<r && r + 1 < nums.length && nums[r] == nums[r+1]; r--);
                } else if (sum < 0) {
                    l++;
                } else /*if (sum > 0)*/ {
                    r--;
                }
            }
            for(;i < nums.length - 1 && nums[i] == nums[i+1]; i++);
        }
        return matches;

    }
}
