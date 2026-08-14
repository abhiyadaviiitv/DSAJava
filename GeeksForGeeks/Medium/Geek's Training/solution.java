class Solution {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int[][] dp = new int[n][3];
        
        // Initialize with -1 to mark uncomputed states
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }
        
        int maxi = 0;
        for (int col = 0; col < 3; col++) {
            maxi = Math.max(maxi, f(mat, n - 1, col, dp));
        }
        
        return maxi;
    }
    
    public int f(int m[][], int row, int lastCol, int[][] dp) {
        if (row < 0) {
            return 0;
        }
        
        if (dp[row][lastCol] != -1) {
            return dp[row][lastCol];
        }
        
        int maxi = 0;
        
        for (int col = 0; col < 3; col++) {
            if (col != lastCol) {
                int points = m[row][col] + f(m, row - 1, col, dp);
                maxi = Math.max(maxi, points);
            }
        }
        
        dp[row][lastCol] = maxi;
        return maxi;
    }
}