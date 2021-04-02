package icu.yezi.leetcode.dp.dp案例学习;

import java.util.Arrays;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.dp.dp案例学习
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/4/2 星期五 10:32
 */
public class Dp最长公共子序列 {

    /**
     * dp数组含义：
     *  dp[i][j] 表示 text1子串(1~i) 和 text2子串(1~j) 最长公共子序列的长度
     * base case
     *  dp[0][0~]=0 dp[0~][0]=0
     * 状态转移方程：
     *  if (text1.charAt(i) == text2.charAt(j)) dp[i][j] = dp[i-1][j-1]+1;
     *  else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        text1 = " "+text1;
        text2 = " "+text2;
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[text1.length()][text2.length()];
        // base case
        for (int[] ints : dp) {
            Arrays.fill(ints,0);
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        return dp[len1-1][len2-1];
    }
}
