/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //递归 时间复杂度O(N) 空间复杂度O(N)
class Solution {
    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root,p,q);
        return ans;
    }

    public boolean dfs(TreeNode root,TreeNode p,TreeNode q) {
        if(root == null) {
            return false;
        }
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);
        if((lson&&rson) || ((root.val == q.val||root.val == p.val)&&(lson||rson))) {
            ans = root;
        }
        return lson||rson||root.val == q.val||root.val == p.val;
    }
}

//代码简洁 思路：根据四种情况进行分析 时间复杂度O(N) 空间复杂度O(N)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null||root == p||root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null&&right == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        return root; //(left != null && right != null) 
    }
}