class Solution {
    int minCost(int[] height) {
        // code here
        
        int dp [] = new int [height.length + 1];
        for(int i=0;i<height.length + 1;i++)
        dp[i] = -1;
          return f(height , height.length-1 , dp);
    }
    
    
    
public int f(int [] height , int idx ,int [] dp)
{
    if(idx == 0) return 0;
    
    
    if(dp[idx] != -1) return dp[idx];
    
    int left = f(height,idx-1,dp) + Math.abs(height[idx] - height[idx-1] );
    int right = Integer.MAX_VALUE;
    if(idx>1)
     right = f(height,idx - 2,dp ) + Math.abs(height[idx] - height[idx-2] );

    dp[idx] = Math.min(left, right);
    return dp[idx];
}
}


