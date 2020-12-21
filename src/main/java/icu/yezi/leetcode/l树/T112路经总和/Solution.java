package icu.yezi.leetcode.l树.T112路经总和;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/path-sum/
 * @PackageName icu.yezi.leetcode.l树.T112路经总和
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/21 星期一 10:29
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        return bfs(root,sum);
    }

    /**
     * BFS实现
     *  一个队列记录将要访问的结点
     *  一个队列记录到达结点的路径和
     * 循环结束条件：
     *  叶子结点路径和 == sum
     * @param root
     * @param sum
     * @return
     */
    public boolean bfs(TreeNode root,int sum){
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        if (root!=null){
            nodeQueue.add(root);
            valQueue.add(root.val);
        }

        while (!nodeQueue.isEmpty()){
            TreeNode cure = nodeQueue.poll();
            Integer temp = valQueue.poll();

            if (cure.left==null && cure.right==null){
                if (temp==sum){
                    return true;
                }
                continue;
            }
            if (cure.left!=null){
                nodeQueue.add(cure.left);
                valQueue.add(temp+cure.left.val);
            }
            if (cure.right!=null){
                nodeQueue.add(cure.right);
                valQueue.add(temp+cure.right.val);
            }
        }

        return false;
    }

    /**
     * 递归实现
     * @param node
     * @param target
     * @return
     */
    public boolean recursion(TreeNode node,int target){
        if (node==null){return false;}
        if (node.left==null && node.right==null && node.val==target){
            return true;
        }
        return recursion(node.left,target-node.val) ||
                recursion(node.right,target-node.val);
    }
}

