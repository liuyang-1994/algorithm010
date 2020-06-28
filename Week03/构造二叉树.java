/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //递归 时空复杂度O(N)
class Solution {

    private Map<Integer,Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i = 0;i < n;i++) {
            indexMap.put(inorder[i],i);
        }
        TreeNode root = buildMyTree(preorder,inorder,0,n-1,0,n-1);
        return root;
    }
    public TreeNode buildMyTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right) {
        if(preorder_left > preorder_right) return null;
        int preorder_root = preorder_left;
        //int inorder_root = indexMap.get(preorder[preorder_root]);
        int inorder_root = indexMap.get(preorder[preorder_root]);
        int left_subtree = inorder_root - inorder_left;
        int right_subtree = inorder_right - inorder_root;
        TreeNode root = new TreeNode(preorder[preorder_root]);
        root.left = buildMyTree(preorder,inorder,preorder_left+1,preorder_left+left_subtree,inorder_left,inorder_left+left_subtree-1);
        root.right = buildMyTree(preorder,inorder,preorder_right-right_subtree+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }
}

//迭代 O(N)
class Solution {
    public TreeNode buildTree(int[] preorder,int[] inorder) {
        if(preorder == null||preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode root = new TreeNode(preorder[0]);
        stack.add(root);
        for(int i = 1;i < preorder.length;i++) {
            int preVal = preorder[i];
            TreeNode node = stack.peek();
            if(node.val != inorder[index]) {
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            }else {
                while(!stack.isEmpty() && stack.peek().val==inorder[index]) {
                    node = stack.pop();
                    index++;
                }
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
            
        }
        return root;
    }

}