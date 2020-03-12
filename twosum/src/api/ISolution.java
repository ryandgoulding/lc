package api;

public interface ISolution {

    /**
     * Given an array of integers (nums), return an array of indices that add up to target.
     *
     * @param nums array of integers
     * @param target the target sum
     * @return an array of two indices that add up to target
     * @link https://leetcode.com/problems/two-sum/
     */
    int[] twoSum(int[] nums, int target);
}
