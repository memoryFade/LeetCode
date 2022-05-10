package lcof;

public class Offer042 {
    public int maxSubArray(int[] nums) {
        int max = nums[0],res = nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
