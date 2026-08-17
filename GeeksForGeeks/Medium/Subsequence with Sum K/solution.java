class Solution {
    
    public boolean checkSubsequenceSum(int[] arr, int k) {
        int n = arr.length;
        Boolean[][] memo = new Boolean[n][k + 1];
        return dpMemo(arr, 0, k, memo);
    }

    private boolean dpMemo(int[] arr, int index, int target, Boolean[][] memo) {
        if (target == 0)
            return true;
        if (index >= arr.length)
            return false;
        if (memo[index][target] != null)
            return memo[index][target];

        boolean notTake = dpMemo(arr, index + 1, target, memo);

        boolean take = false;
        if (target >= arr[index])
            take = dpMemo(arr, index + 1, target - arr[index], memo);

        memo[index][target] = take || notTake;
        return memo[index][target];
    }


}