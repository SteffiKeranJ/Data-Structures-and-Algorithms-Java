/**
Given an integer array nums of unique elements, return all possible
subsets
(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

**/

class Solution {
    static int l;
    public List<List<Integer>> subsets(int[] nums) {
        l = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, result, temp, 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int idx) {
        result.add(new ArrayList<>(temp)); // pick the number
        for(int i = idx; i < l; ++i) {
            temp.add(nums[i]); // dont pick the number
            backtrack(nums, result, temp, i+1); 
            temp.remove(temp.size() - 1); // backtrack
        }
        
    }
}
