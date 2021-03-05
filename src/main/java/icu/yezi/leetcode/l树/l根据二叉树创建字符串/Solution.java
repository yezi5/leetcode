package icu.yezi.leetcode.l树.l根据二叉树创建字符串;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * @PackageName icu.yezi.leetcode.l树.l根据二叉树创建字符串
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/4 星期四 16:40
 */
public class Solution {
    // 未通过写法
    /*{
        private int count;
        private String rs = "";
        *//**
         * 分析：
         *  分成三种情况
         *      ① 左右子树都存在：(左子树)(右子树)  不用额外加 ()
         *      ② 左子树存在，右子树不存在： (左子树) 右子树不用额外加空()
         *      ③ 左子树不存在，右子树存在： ()(右子树)
         *
         *
         *
         * @param t
         * @return
         *//*
        public String tree2str(TreeNode t) {
        treeStr(t);
        rs = rs.substring(0,rs.length()-2);
        return rs;
    }

        public void treeStr(TreeNode root){
        if (root == null) return;

        boolean liftNotNull = root.left != null;
        boolean rightNotNull = root.right != null;

        rs += root.val;

        if (!liftNotNull && !rightNotNull && count != 0){
            for (int i = 0; i < count; i++) {
                rs+=")";
            }
            count = 0;
        }

        if (!liftNotNull && rightNotNull){
            rs += "()(";
        }else {
            rs += "(";
        }
        count++;

        treeStr(root.left);
        treeStr(root.right);
    }
    }*/

    private StringBuffer buff;

    /**
     * ① 左右子树都不存在：""
     * ② 左子树存在，右子树不存在： (左子树) 右子树不用额外加空()
     * ③ 左子树不存在，右子树存在： ()(右子树)
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        if (t == null){
            return "";
        }
        if (t.left==null && t.right==null){
            return t.val+"";
        }
        if (t.right==null){
            return t.val+"("+tree2str(t.left)+")";
        }

        return t.val+"("+tree2str(t.left)+")"+"("+tree2str(t.right)+")";
    }

    /**
     * 方法三
     * @param root
     */
    public void build(TreeNode root){

        if (root == null) return;
        buff.append(root.val);
        if (root.left!=null || root.right!=null){
            buff.append("(");
            build(root.left);
            buff.append(")");

            if (root.right != null){
                buff.append("(");
                build(root.right);
                buff.append(")");
            }
        }

    }
}
