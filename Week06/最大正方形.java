class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null)
            return max; 
        int w = matrix.length;
        int h = matrix[0].length;
        int[][] dp = new int[w][h];

        for(int i = 0;i < w;i++) {
            for(int j = 0;j < h;j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
                    }
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
    }
}