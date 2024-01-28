/** 
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.
Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

**/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int l, r;
        long sum;
        HashSet<List<Integer>> hSet = new HashSet<>();

        for(int i = 0; i < n-3; ++i) {
            for(int j = i+1; j < n-2; ++j) {
                l = j+1;
                r = n-1;
                while(l < r) {
                    sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target) {
                        hSet.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }
                    else if(sum < target) l++;
                    else if(sum > target) r--;
                }
            }
        }
        return new ArrayList<>(hSet);
    }
}

