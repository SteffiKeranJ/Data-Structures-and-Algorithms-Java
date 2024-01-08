/**
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.
**/

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        int count = 0;
        int l = 0, r =0;
        long result = 0L;
        while(r < n) {
            if(nums[r]==maxElement) count++;
            while(count >= k) {
                result+= n-r;
                if(nums[l]==maxElement) count-=1;
                l++;
            }
            r++;
        }
        return result;
    }
}


