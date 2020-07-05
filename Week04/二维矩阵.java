class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        int left = 0, right = n*m - 1;
        int idx,ele;
        while(left <= right) {
            idx = (left + right) /2;
            ele = matrix[idx/n][idx%n];
            if(ele == target) return true;
            else {
                if(ele < target) left = idx + 1;
                else right =  idx - 1;
            }
        }
        return false;
        
    }
}