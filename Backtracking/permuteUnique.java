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
    static List<List<Integer>> ans;
    static int l;

    private static void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    private static void helper(int[] nums, int idx) {
        if(idx == l-1) {
            ans.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        HashSet<Integer> uniqueSet = new HashSet<>();
        for(int i = idx; i < l; ++i) {
            if(uniqueSet.contains(nums[i])) continue;
            uniqueSet.add(nums[i]);
            swap(nums, i, idx);
            helper(nums, idx+1);
            swap(nums, i, idx);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        l = nums.length;
        helper(nums, 0);
        return ans;
    }
}
