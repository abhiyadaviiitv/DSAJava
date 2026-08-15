class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int j = 0; j < n; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                int leftDiag = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                int rightDiag = Integer.MAX_VALUE;

                if(j - 1 >= 0) {
                    leftDiag = dp[i + 1][j - 1];
                }
                
                down = dp[i + 1][j];
                
                if(j + 1 < n) {
                    rightDiag = dp[i + 1][j + 1];
                }

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }

        int minSum = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }

        return minSum;
    }
}
