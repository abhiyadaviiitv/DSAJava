class Solution {
    public int maxChocolate(int grid[][]) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        int i = 0;
        int j = 0;
        int k = grid[0].length-1;
        int [][][] dp = new int [n][m][m];
        
        for(int x=0;x<n;x++)
        {
            for(int y=0;y<m;y++)
            {
                for(int z=0;z<m;z++)
                {
                    dp[x][y][z] = -1;
                }
            }
        }
        
        return f(grid , i , j, k , dp);
    }
    
    public int f(int [][] a , int i , int j , int k , int [][][] dp)
    {   
        int size = a.length;
        int m = a[0].length;
        if(i >= size ||j < 0 || j>=m || k< 0 || k>=m)
            return 0;
        
        if(i == size-1)
        {
            if( j == k ) return a[i][j];
            else return a[i][j] + a[i][k];
        }
        
        if(dp[i][j][k] !=-1)
         return dp[i][j][k];
        
        int re =0;
        int maxi = 0;
        
        for(int dj1 = -1; dj1<2;dj1++)
        {
            for(int dj2 = -1; dj2<2;dj2++)
            {
                if(j == k)
                re = a[i][j] + f(a,i+1,j+dj1,k+dj2,dp);
                else
                 re = a[i][j] + a[i][k] + f(a,i+1,j+dj1,k+dj2,dp);
                 
                
                 
                 maxi =Math.max(re,maxi);
            }
        }
        
        dp[i][j][k] = maxi;
        
        
        return dp[i][j][k];
        
    }
}