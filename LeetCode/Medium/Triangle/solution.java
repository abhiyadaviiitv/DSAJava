class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
        }
        // dp[n-1][j] = triangle[n-1][j] (just the values themselves)
        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int down = dp[i + 1][j];
                int diagonal = dp[i + 1][j + 1];
                
                // Current value + minimum of two paths below
                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
            }
        }
        
        return dp[0][0];
    }
}