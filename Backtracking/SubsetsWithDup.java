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
    static int l;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        l = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> hSet = new HashSet<>();
        backTrackHelper(hSet, new ArrayList<>(), nums, 0);
        result.addAll(hSet);
        return result;
    }

    private static void backTrackHelper(HashSet<List<Integer>> hSet, List<Integer> temp, int[] nums, int idx) {
        if(idx >= l)  {
            hSet.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        backTrackHelper(hSet, temp, nums, idx+1);
        temp.remove(temp.size() -1);
        backTrackHelper(hSet, temp, nums, idx+1);
    }
}
