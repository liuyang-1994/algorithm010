/**
* 26. 删除排序数组中的重复项
**/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1;i < nums.length;i++) {
            if (nums[count] != nums[i]) {
                count ++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }
}