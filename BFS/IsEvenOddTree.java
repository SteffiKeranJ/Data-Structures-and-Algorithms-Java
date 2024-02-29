public class LevelNode {
    TreeNode node;
    int level;

    LevelNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<LevelNode> q = new LinkedList<>();

        q.offer(new LevelNode(root, 0));
        int prev = root.val;
        int n;
        while(q.peek() != null) {
            prev = -1;
            n = q.size();
            for(int i = 0; i < n; ++i) {
                LevelNode levelNode = q.poll();
                int level = levelNode.level;
                TreeNode treeNode = levelNode.node;
                int treeNodeVal = treeNode.val;
                if((level%2) == (treeNodeVal%2)) return false;
                if(level%2 == 1 && (prev!=-1 && treeNodeVal >= prev)) return false;
                if(level%2 == 0 && (prev!=-1 && treeNodeVal <= prev)) return false; 
                
                if(treeNode.left != null) q.offer(new LevelNode(treeNode.left, level+1));
                if(treeNode.right != null) q.offer(new LevelNode(treeNode.right, level+1));
                prev = treeNodeVal;
            }

        }
        return true;
    }
}
