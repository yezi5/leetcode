package icu.yezi.dataStructure.tree.l普通的树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.dataStructure.tree.l普通的树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/5 星期五 19:40
 */
public class 基础算法 {

    /**
     * 计算树的最大深度
     * @param root
     * @return
     */
    public int depth(TreeNode root){
        if (root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }

    /**
     * 二叉树最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;

        return root;
    }

    /**
     * 从前序遍历结果+中序遍历结果还原二叉树
     *
     * 首先，需要了解前序遍历和中序遍历的特点：
     *
     * 前序遍历：首次访问的必定是根结点
     * 中序遍历：根结点左侧全部为左子树结点，根结点右侧全部为右子树结点
     *
     * 根据前序遍历和中序遍历的特点，我们可以第一时间得到该树的根结点
     *
     * 运用递归的思想，我们要获得根结点的左子结点，只需要对现在的前、中序遍历结果进行剪枝
     * 获得左子树的前、中序遍历结果即可
     *
     * 右子结点同理
     *
     * 如何对现在的遍历结果进行剪枝，获得对应子树的遍历结果，
     * 继续分析前、中后序遍历结果
     *  我们知道中序遍历结果中根结点左侧即为左子树中序遍历结果 --> 可以得到左子树结点个数 leftNumLength
     *  左子树
     *      前序遍历起始索引：（前序start+1，前序start+leftNumLength） 
     *      中序遍历起始索引：（后序start，后序中root索引-1）
     * 右子树同理分析
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd,
                                                                 int[] inorder, int inStart, int inEnd, Map<Integer,Integer> map){

        if (preStart>preEnd || inStart>inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(root.val);
        int leftNumLength = rootIndex - inStart;

        root.left = helper(preorder,preStart+1,preStart+leftNumLength,inorder,inStart,rootIndex-1,map);
        root.right = helper(preorder,preStart+leftNumLength+1,preEnd,inorder,rootIndex+1,inEnd,map);

        return root;
    }
}
