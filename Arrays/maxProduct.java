/**
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

**/

class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0], minSoFar = nums[0], maxSoFar = nums[0];
        int l = nums.length;
        for(int i = 1; i < l; ++i) {
            int temp = Math.max(nums[i], Math.max(nums[i]*minSoFar, nums[i]*maxSoFar));
            minSoFar = Math.min(nums[i], Math.min(nums[i]*minSoFar, nums[i]*maxSoFar));
            maxSoFar = temp;
            result = Math.max(result, maxSoFar);
        }
        return result;
    }
}
