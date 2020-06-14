/**
* 189. 旋转数组
**/
class Solution {
    public void rotate(int[] nums, int k) {
        //暴力，，创建一个数组复制，,环状替换
        int len = nums.length;
        // int temp , prev;
        // for (int i = 0;i < k;i++) {
        //     prev = nums[len-1];
        //     for (int j = 0;j < nums.length;j++) {
        //         temp = nums[j];
        //         nums[j] = prev;
        //         prev = temp;

        //     }
        // }

        // int arr[] = new int[len];
        // for (int i = 0;i < len;i++) {
        //     int cur = (i + k) % len;
        //     arr[cur] = nums[i];
        // }
        // for (int i = 0;i < len;i++) {
        //     nums[i] = arr[i];
        // }

        int count = 0;
        int temp,prev ;
        for (int start = 0;count < len;start++) {
            int current = start;
            prev = nums[start];
            do {
                int next = (current + k) % len;
                temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count ++;
            } while (start != current);
        }
    }
}