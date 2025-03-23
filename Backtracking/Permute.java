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
