package icu.yezi.leetcode.l树.L654最大二叉树;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/maximum-binary-tree/
 * @PackageName icu.yezi.leetcode.l树.L654最大二叉树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/18 星期五 12:46
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {3,2,1,6,0,5};
        solution.constructMaximumBinaryTree(array);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums,0,nums.length-1);
    }

    /**
     * 尝试使用遍历模板解决的第一道题，真的很香
     *
     * 套用前序遍历的模板
     *   1. 先创建根结点
     *   2. 递归创建左子树
     *   3. 递归创建右子树
     *
     * 注意创建左右子树时要更新数组的起始索引
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode traverse(int[] nums, int start, int end) {
        // 边界判断
        if (start>end){
            return null;
        }
        // 标记最大值和最大值索引
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        // 获取最大值
        for (int i = start; i <= end; i++) {
            if (max<nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }
        // 创建根结点
        TreeNode root = new TreeNode(max);

        // 最大值左侧数据构建左子树
        root.left = traverse(nums,start,maxIndex-1);
        // 最大值右侧数据构建右子树
        root.right = traverse(nums,maxIndex+1,end);

        return root;
    }
}



