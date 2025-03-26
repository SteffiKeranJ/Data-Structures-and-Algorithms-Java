/*
Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]

*/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        backtrack(nums, n, new ArrayList<Integer>(), 0);
        return result;    
    }

    private void backtrack(int[] nums, int n, List<Integer> temp, int index) {
        if(temp.size() > 1) result.add(new ArrayList<>(temp));
        boolean[] used = new boolean[201];
        for(int i = index; i < n; ++i) {
            if(temp.size() >= 1 && temp.get(temp.size()-1) > nums[i] || used[nums[i]+100]) continue;

            temp.add(nums[i]);
            used[nums[i]+100] = true;
            backtrack(nums, n, temp,i+1);
            temp.remove(temp.size()-1);
            
        }

    }
}
