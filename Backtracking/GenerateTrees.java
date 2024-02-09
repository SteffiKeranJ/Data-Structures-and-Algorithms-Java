/**
Given an integer n, return all the structurally unique BST's (binary search trees), 
which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
Example 1:

Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

Example 2:

Input: n = 1
Output: [[1]]

**/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n+1][n+1];
        return backTrack(dp, 1, n);
    }

    private List<TreeNode> backTrack(List<TreeNode>[][] dp, int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        if(dp[start][end] != null) return dp[start][end];

        for(int i = start; i <= end; ++i) {
            List<TreeNode> leftSubTree = backTrack(dp, start, i-1);
            List<TreeNode> rightSubTree = backTrack(dp, i+1, end);

            for(TreeNode left: leftSubTree) {
                for(TreeNode right: rightSubTree) {
                    list.add(new TreeNode(i, left, right));
                }
            }
        }
        return dp[start][end] = list;
    }
}
