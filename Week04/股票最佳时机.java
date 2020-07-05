class Solution {
    public int maxProfit(int[] prices) {
        int vallery = prices[0];
        int peak = prices[0];
        int max = 0;
        int i = 0;
        while(i < prices.length-1) {
            while(i < prices.length-1&&prices[i] >= prices[i+1]) {
                i++;
            }
            vallery = prices[i];
            while(i < prices.length-1&&prices[i] <= prices[i+1]){
                i++;
            }
            peak = prices[i];
            max += (peak - vallery);
        }
        return max;
    }
}
//简简单单一次递归
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 1;i<prices.length;i++) {
            if(prices[i-1] <= prices[i]) max += prices[i] - prices[i-1];
        }
        return max;
    }
}