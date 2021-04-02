package icu.yezi.leetcode.dp.dp案例学习;

import java.util.Arrays;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.dp.dp案例学习
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/4/2 星期五 9:00
 */
public class Dp最长递增子序列 {

    /**
     * dp数组含义：
     *      以索引 i 为结尾的最长递增子序列长度为 dp[i]
     * 初始状态：
     *      dp[0] = 1
     * 状态转移方程
     *      if (nums[i] > nums[j]) dp[i] = Integer.max(dp[i],dp[j]+1);
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        for (int i : dp) {
            res = Math.max(res,i);
        }

        return res;
    }
}
