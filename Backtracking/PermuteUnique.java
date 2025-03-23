/**
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
**/

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }

    private void backTrack(int[] nums, List<Integer> list, boolean[] used) {
        if(list.size() == nums.length) result.add(new ArrayList<>(list));
        for(int i = 0; i < nums.length; ++i) {
            if(used[i]) continue;
            // to skip dups
            if(i > 0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            list.add(nums[i]);
            used[i] = true;
            backTrack(nums, list, used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}
