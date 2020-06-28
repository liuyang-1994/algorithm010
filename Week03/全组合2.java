//回溯+剪枝
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len < 0 ) {
            return res;
        }
        Arrays.sort(nums);
        Deque<Integer> out = new ArrayDeque<>();
        boolean used[] = new boolean[len];
        dfs(nums,len,0,out,res,used);
        return res;
    }
    public void dfs(int[] nums ,int len ,int begin ,Deque<Integer> out,List<List<Integer>> res,boolean[] used) {
        if(begin == len) {
            res.add(new ArrayList<>(out));
            return;
        }
        for(int i = 0;i < len;i++) {
            if(used[i]) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            out.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,begin+1,out,res,used);
            out.removeLast();
            used[i] = false;
        }
    }
}