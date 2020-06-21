/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //中序
class Solution {
    //递归
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     helper(root,res);
    //     return res;
    // }
    // public void helper(TreeNode root,List<Integer> res) {
    //     if(root != null) {
    //         if(root.left != null) {
    //             helper(root.left,res);
    //         }
    //         res.add(root.val);
    //         if(root.right != null) {
    //             helper(root.right,res);
    //         }
    //     }
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        // if(root == null) {
        //     return output;
        // }

        //stack.add(root);
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()) {
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;                
            }
            curr = stack.pollLast();
            output.add(curr.val);
            curr = curr.right;
        }

        return output;

    }
}