package lc.impl;

import lc.api.IThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumSetImpl implements IThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }
    public List<List<Integer>> threeSum(int [] nums, int target) {
        Set<List<Integer>> tripletSet = new HashSet<>();
        if (nums == null || nums.length < 3) return new ArrayList<>(tripletSet);

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    List<Integer> indexList = new ArrayList<>();
                    indexList.add(nums[i]); indexList.add(nums[j]); indexList.add(nums[k]);
                    tripletSet.add(indexList);
                    j++; k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return new ArrayList<>(tripletSet);
    }

}
