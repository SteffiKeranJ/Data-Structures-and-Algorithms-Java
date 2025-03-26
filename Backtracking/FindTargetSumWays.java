// please check the dp version for this solution
class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        backtrack(nums, 0, 0, target);
        return count;    
    }

    private void backtrack(int[] nums, int index, int temp, int target) {
        if(index == nums.length) {
            if(temp == target) count++;
            return;
        }
        backtrack(nums, index+1, temp-nums[index], target);
        backtrack(nums, index+1, temp+nums[index], target);
    }



}
