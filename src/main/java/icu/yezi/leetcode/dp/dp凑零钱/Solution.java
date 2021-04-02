package icu.yezi.leetcode.dp.dp凑零钱;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.dp.dp凑零钱
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/11 星期四 20:01
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        Map<Integer,Integer> memo = new HashMap<>();

        return dp(coins,amount,memo);
    }

    public int dp(int[] coins, int amount,Map<Integer,Integer> memo){
        if (memo.containsKey(amount)) return memo.get(amount);
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int child = dp(coins,amount-coin,memo);
            if (child == -1) continue;
            res = Integer.min(res,child+1);
        }

        memo.put(amount,res==Integer.MAX_VALUE?-1:res);
        return memo.get(amount);
    }

    /**
     * 迭代写法
     *
     * 1. 初始状态
     * 2. dp数组含义
     * 2. 状态转移方程
     *
     * 初始状态：
     *      dp[0] = 0 ， 0元需要0个硬币
     * dp[i]含义：
     *      凑齐i元，需要dp[i]枚硬币
     * 状态转移方程：
     *
     *      dp[i] = Math.min(dp[i],dp[i-coin]+1);
     *
     * dp[i-coin]+1 (i-coin)元所需最少硬币+1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);

        // base case
        dp[0] = 0;

        // 遍历所有状态
        for (int i = 0; i < (amount + 1); i++) {
            // 遍历所有选择，求取最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i < coin) continue;
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }

        return (dp[amount]==amount+1)?-1:dp[amount];
    }
}
