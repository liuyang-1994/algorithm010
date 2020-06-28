//回溯
class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(k <= 0||n <= 0||n <k) {
            return res;
        }
        findCombinations(n,k,1,new LinkedList<Integer>());
        return res;
    }
    public void findCombinations(int n,int k,int begin,LinkedList<Integer> stack) {
        if(stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i = begin;i <= n;i++) {
            stack.add(i);
            findCombinations(n,k,i+1,stack);
            stack.pollLast();
        }
    } 
}