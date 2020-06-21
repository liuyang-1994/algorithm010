/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
//层序
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = stack.size();
            for(int i = 0;i < size;i++) {
                Node node = stack.poll();
                level.add(node.val);
                stack.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }
}