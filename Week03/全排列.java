class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len <= 0) {
            return res;
        }
        ArrayList<Integer> out = new ArrayList<>();
        boolean used[] = new boolean[len];
        dfs(nums,len,0,out,res,used);
        return res;
    }

    public void dfs(int[] nums,int len,int begin,List<Integer> out,List<List<Integer>> res,boolean[] used) {
        if(begin == len) {
            res.add(new ArrayList<>(out));
            return;
        }
        for(int i = 0;i<len;i++) {
            if(!used[i]){
                used[i] = true;
                out.add(nums[i]);
                dfs(nums,len,begin + 1,out,res,used);
                used[i] = false;
                out.remove(out.size() - 1);
            }
        }
    }
}