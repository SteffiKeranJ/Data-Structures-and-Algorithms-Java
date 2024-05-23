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
    List<String> binaryValStrings = new ArrayList<>();

    private void dfs(TreeNode root, String binVal) {
        if(root == null) {
            return;
        }
        binVal = binVal + Integer.toString(root.val);

        if(root.left == null && root.right == null) {
            binaryValStrings.add(binVal);
            return;
        }

        dfs(root.left, binVal);
        dfs(root.right, binVal);        
    }

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, "");
        int result = 0;
        for(String binStr: binaryValStrings) {
            result += Integer.parseInt(binStr, 2);
        }
        return result;
    }
}
