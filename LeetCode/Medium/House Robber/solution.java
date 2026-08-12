class Solution {
    public int rob(int[] nums) {

         
        int dp [] = new int [nums.length + 1];
        for(int i=0;i<nums.length + 1;i++)
        dp[i] = -1; 
        int idx = nums.length-1;
        return f(idx , nums ,dp);
        
    }

    public int f(int idx , int [] nums , int [] dp)
    {
        if(idx == 0) return nums[0];

        if(idx < 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        int take = nums[idx] + f(idx-2 , nums,dp);
        int nottake = 0 + f(idx-1 , nums,dp);

        dp[idx] = Math.max(take,nottake);
        return dp[idx];
    }
}