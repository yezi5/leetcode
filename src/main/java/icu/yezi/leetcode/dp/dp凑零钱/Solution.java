package icu.yezi.leetcode.dp.dp凑零钱;

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
}
