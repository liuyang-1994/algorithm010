//两数之和
class Solution {
    //一遍哈希表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> coll = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            int res = target - nums[i];
            if (coll.containsKey(res)) {
                return new int[]{coll.get(res),i};
            }
            coll.put(nums[i],i);
        } 
       throw new IllegalArgumentException("No two sum solution");
    }
}