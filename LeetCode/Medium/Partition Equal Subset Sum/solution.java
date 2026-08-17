class Solution {
    public boolean canPartition(int[] nums) {
        

        int n = nums.length;
        int k = 0;
        for(int i=0;i<n;i++)
        {
            k+= nums[i];
        }
        if(k%2 !=0)
            return false;
        k =  k/2;
        Boolean[][] memo = new Boolean[n][k + 1];

        return f(nums, 0, k, memo);


    }

    private boolean f(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0)
            return true;
        if (index >= nums.length)
            return false;
        if (memo[index][target] != null)
            return memo[index][target];

        boolean notTake = f(nums, index + 1, target, memo);

        boolean take = false;
        if (target >= nums[index])
            take = f(nums, index + 1, target - nums[index], memo);

        memo[index][target] = take || notTake;
        return memo[index][target];
    }
}