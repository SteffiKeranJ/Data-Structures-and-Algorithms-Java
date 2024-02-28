/**
Given the root of a binary tree, return the leftmost value in the last row of the tree.
Example 1:

Input: root = [2,1,3]
Output: 1

Example 2:

Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7

**/
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(q.peek() != null) {
            root = q.poll();
            if(root.right !=null) q.offer(root.right);
            if(root.left !=null) q.offer(root.left);
        }
        return root.val;
    }
}
