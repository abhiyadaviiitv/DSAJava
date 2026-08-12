class Solution {
    public int rob(int[] nums) {

         if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
         int dp [] = new int [nums.length + 1];
        // for(int i=0;i<nums.length + 1;i++)
        // dp[i] = -1; 
         int idx = nums.length-1;
        // return f(idx , nums ,dp);

        dp[0] = 0;

        for(int i=1;i<=idx;i++)
        {
        int take = 0;
        if(i>1)
         take = nums[i] + dp[i-2];
        else 
         take = nums[i];
        int nottake = 0 + dp[i-1];

        dp[i] = Math.max(take,nottake);
        }

        int max = dp[idx];

         dp[0] = nums[0];

        for(int i=1;i<idx;i++)
        {
        int take = 0;
        if(i>1)
         take = nums[i] + dp[i-2];
        else 
         take = nums[i];
        int nottake = 0 + dp[i-1];

        dp[i] = Math.max(take,nottake);
        }

        return Math.max(dp[idx-1],max);
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