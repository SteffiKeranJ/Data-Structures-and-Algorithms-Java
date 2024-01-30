/**
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
**/

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrackHelper(1, n, k);
        return result;
    }

    private void backTrackHelper(int index, int n, int k) {
        if(combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i = index; i <=n; ++i) {
            combination.add(i);
            backTrackHelper(i+1, n, k);
            combination.remove(combination.size() - 1);
        }
    }
}
