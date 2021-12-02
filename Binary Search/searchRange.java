/** 
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

**/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int start, end;
        int left = 0, right = n;
        while(left < right) {
            int mid = (left + right)>>1;
            if(nums[mid]>=target) right = mid;
            else left = mid+1;
        }
        start = left;
        left = 0; right = n;
        while(left < right) {
            int mid = (left + right)>>1;
            if(nums[mid]>target) right = mid;
            else left = mid+1;
        }
        end = left;
        return (start == end) ? new int[]{-1, -1} : new int[]{start, end-1};
        
    }
}
