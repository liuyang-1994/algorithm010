class Solution {
    public boolean canJump(int[] nums) {
        int rightMax = 0;
        for(int i = 0;i < nums.length;i++) {
            if(i > rightMax) {
                return false;
            }
            rightMax = Math.max(rightMax,nums[i] + i);
        }
        return true;
    }
	//大神解法
	public boolean canJump(int[] nums) {
        int reachAble = nums.length - 1;
        for(int i = nums.length-1;i >= 0;i--) {
            if(nums[i] + i >= reachAble) {
                reachAble = i;
            }
        }
        return reachAble == 0;
    }
}