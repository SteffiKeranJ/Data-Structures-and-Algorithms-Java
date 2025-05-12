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
    List<List<Integer>> result;

    private void bfsHelper(Queue<TreeNode> queue, int ql) {

        if(queue.isEmpty()) return;
        List<Integer> temp = new ArrayList<>();
        
        for(int i = 0; i < ql; ++i){
            TreeNode node = queue.poll();
            temp.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        result.addFirst(new ArrayList<>(temp));
        bfsHelper(queue, queue.size());

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        bfsHelper(q, q.size());
        // Collections.reverse(result);
        return result;
    }
}
