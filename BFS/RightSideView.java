/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]


Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]


Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []

*/

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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        q.offer(root);
        int l;
        while(!q.isEmpty()) {
            l = q.size();
            while(l > 0) {
                TreeNode node = q.poll();
                if(node.left !=null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                if(l == 1) result.add(node.val);
                l--;
            }
        }
        return result;
        
    }
}
