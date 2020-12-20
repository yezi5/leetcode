package icu.yezi.dataStructure.tree.l普通的树;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.dataStructure.tree.l普通的树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/20 星期日 11:47
 */
public class L计算结点个数 {

    /**
     * 计算普通二叉树结点个数
     * @param root
     * @return
     */
    public Integer countBT(TreeNode root){
        if (root==null){return 0;}
        return countBT(root.left)+countBT(root.right)+1;
    }

    /**
     * 计算满二叉树结点个数
     * @param root
     * @return
     */
    public Integer countFBT(TreeNode root){
        int h = 0;
        while (root!=null){
            h++;
            root=root.left;
        }
        return (int)Math.pow(2,h)-1;
    }

    public Integer countCBT(TreeNode root){
        int lh = 0;
        int rh = 0;
        TreeNode l = root;
        TreeNode r = root;

        while (l!=null){
            lh++;
            l=l.left;
        }
        while (r!=null){
            rh++;
            r=r.right;
        }
        if (lh==rh){
            return (int)Math.pow(2,lh)-1;
        }

        return countCBT(root.left)+countCBT(root.right)+1;
    }
}
