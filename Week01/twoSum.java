/**
* 1. 两数之和
**/
class Solution {
    //一遍哈希表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> maps = new HashMap();
        for (int i = 0;i < nums.length;i++) {
            int comp = target - nums[i];
            if (maps.containsKey(comp)) {
                return new int[] {maps.get(comp) , i};
            }
            maps.put(nums[i] , i);

        }
       throw new IllegalArgumentException("No two sum solution");
    }
}