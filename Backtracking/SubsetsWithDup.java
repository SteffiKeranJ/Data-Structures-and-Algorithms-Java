/**
Given an integer array nums that may contain duplicates, return all possible
subsets.

The solution set must not contain duplicate subsets. Return the solution in any order. 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

**/

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> path = new HashSet<>();
        backtrack(0, nums, path, new ArrayList<Integer>());
        result.addAll(path);
        return result;
    }

    private void backtrack(int index, int[] nums, HashSet<List<Integer>> path, List<Integer> temp) {
        path.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; ++i) {
            temp.add(nums[i]);
            backtrack(i+1, nums, path, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
