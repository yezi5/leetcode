package icu.yezi.leetcode.dp.dp引入学习;


import java.util.Arrays;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.dp.dp引入学习
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/10 星期三 20:35
 */
public class 斐波那契数列 {

    public int fib(int n) {
        int[] list = new int[n+1];
        Arrays.fill(list,0);
        return method3(n,list);
    }

    /**
     * 超时
     * @param n
     * @return
     */
    public int method1(int n){
        if (n == 0) return 0;
        if (n==1 || n==2) return 1;
        return (method1(n-1) + method1(n-2))%1000000007;
    }

    public int method2(int n){
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public int method3(int n, int[] list){
        if (n == 0) return 0;
        if (n==1 || n==2) return 1;
        if (list[n] != 0) return list[n];
        list[n] = (method3(n-1,list) + method3(n-2,list)) % 1000000007;

        return list[n];
    }
}
