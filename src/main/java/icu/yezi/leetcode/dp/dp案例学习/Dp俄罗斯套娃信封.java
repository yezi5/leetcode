package icu.yezi.leetcode.dp.dp案例学习;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.dp.dp案例学习
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/4/2 星期五 9:33
 */
public class Dp俄罗斯套娃信封 {

    /**
     * 思路分析：
     *  1. 对 w 升序排序，问题转化为对 h 的LIS问题
     *      存在问题：w相同的信纸可能出现在同一个序列中
     *  2. 问题解决
     *      若 w 相同，对 h 进行降序排序
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]==b[0] ? b[1]-a[1] : a[0]-b[0];
            }
        });

        int[] nums = new int[envelopes.length];

        for (int i = 0; i < envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }

        return lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }

        int res = 0;

        for (int i : dp) {
            res = Math.max(res,i);
        }
        return res;
    }

}
