package icu.yezi.leetcode.dp.dp案例学习;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.dp.dp案例学习
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/4/2 星期五 10:00
 */
public class Dp连续子数组最大和 {

    /**
     * dp数组含义：
     *      以索引 i 为结尾的连续子数组最大和
     * 初始状态：
     *      dp[0] = nums[0]
     * 状态转移方程：
     *      dp[i] = Math.max(nums[i],dp[i-1]+nums[i])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        // base case
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int res = Integer.MIN_VALUE;

        for (int i : dp) {
            res = Math.max(res,i);
        }

        return res;
    }
}
