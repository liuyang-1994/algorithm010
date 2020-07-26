class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] hang=new int[9][9];//row
        int[][] lie=new int[9][9];//colomn
        int[][] gezi=new int[9][9];//9-digit cell
        
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                int x = board[i][j] - '0';
                if(x >= 0 && x <= 9) {
                    hang[i][x -1]++;
                    lie[i][x - 1]++;
                    gezi[i/3*3 + j/3][x - 1]++;
                    if(hang[i][x - 1] > 1||lie[i][x - 1] > 1||gezi[i/3*3+j/3][x -1] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}