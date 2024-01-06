/**
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.
**/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if(n < 3) return 0;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int i, tempSum, diff;

        AtomicInteger index = new AtomicInteger(0);
        while(index.get() < n-2) {
            for (int left = index.get() + 1, right = n - 1; left < right;) {
                tempSum = nums[index.get()] + nums[left] + nums[right];
                if (tempSum == target) {
                    return tempSum;
                } else if (tempSum < target) {
                    left++;
                } else {
                    right--;
                }

                diff = Math.abs(tempSum-target);
                if(diff < Math.abs(result - target)) result = tempSum;
            }
            index.incrementAndGet();
        }

        return result;     
    }
}
