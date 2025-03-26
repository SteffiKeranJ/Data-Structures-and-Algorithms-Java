/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".

Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:

Input: nums = [1], target = 1
Output: 1

 

Constraints:

    1 <= nums.length <= 20
    0 <= nums[i] <= 1000
    0 <= sum(nums[i]) <= 1000
    -1000 <= target <= 1000


*/
class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
        for (int num : nums) sum += num;
        int n = nums.length;
        // If target is outside possible range, no solution
        if (Math.abs(target) > sum) return 0;
        Integer[][] memo = new Integer[n][2 * sum + 1];  // Index: [i][currSum + sum]
        return dp(memo, nums, target, 0, 0, sum);
    }
    private int dp(Integer[][] memo, int[] nums, int target, int index, int currSum, int offset) {
        // Out-of-bound check (currSum + offset must be within array index range)
        if (currSum + offset < 0 || currSum + offset >= memo[0].length) {
            return 0;
        }
        if (index == nums.length) {
            return currSum == target ? 1 : 0;
        }
        if (memo[index][currSum + offset] != null) {
            return memo[index][currSum + offset];
        }
        int add = dp(memo, nums, target, index + 1, currSum + nums[index], offset);
        int subtract = dp(memo, nums, target, index + 1, currSum - nums[index], offset);
        
        return memo[index][currSum + offset] = add + subtract;
    }
}






