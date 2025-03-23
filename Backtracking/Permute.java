/*
46. Permutations

Given an array nums of distinct integers, return all the possible

. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

*/

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        backtrack(new ArrayList<Integer>(), new boolean[n], nums);
        return result;
    }

    private void backtrack(List<Integer> path, boolean[] used, int[] nums) {
        int n = nums.length;
        if(path.size() >= n) {
            result.add(new ArrayList<>(path));
        }

        for(int i = 0; i < n; ++i) {
            if(used[i] == true) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(path,used, nums);
            used[i] = false;
            path.remove(path.size()-1);

        }
    }
}
