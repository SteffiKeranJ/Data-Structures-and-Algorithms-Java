/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

 
*/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        backtrack(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> temp ) {
        if(target == 0) result.add(new ArrayList<>(temp));
        for(int i = index; i < candidates.length; ++i) {
            if(candidates[i] > target) continue;
            if(i > index && candidates[i]==candidates[i-1]) continue;
            temp.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i+1, temp);
            temp.remove(temp.size()-1);
            
        }
    }
}
