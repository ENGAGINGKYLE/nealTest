package org.neal.javaLearn.offer.jianzhiOffer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 找出根节点，然后利用递归方法构造二叉树
 */

public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }
}

/**
 * 已知中序和后序  求前序
 * public class Main {
 *
 *      public static class TreeNode {
 *           int val;
 *           TreeNode left;
 *           TreeNode right;
 *           TreeNode(int x) { val = x; }
 *       }
 *
 *      public static TreeNode reConstructBinaryTree(int [] post,int [] in) {
 *             TreeNode root=reConstructBinaryTree(post,0,post.length-1,in,0,in.length-1);
 *             return root;
 *         }
 *
 *
 *         private static TreeNode reConstructBinaryTree(int [] post,int startPost,int endPost,int [] in,int startIn,int endIn) {
 *
 *             if(startPost>endPost||startIn>endIn)
 *                 return null;
 *
 *             TreeNode root=new TreeNode(post[endPost]);
 *
 *             for(int i=startIn;i<=endIn;i++)
 *                 if(in[i]==post[endPost]){
 *                     root.left=reConstructBinaryTree(post,startPost,startPost+i-startIn-1,in,startIn,i-1);
 *                     root.right=reConstructBinaryTree(post,startPost+i-startIn,endPost-1,in,i+1,endIn);
 *                 }
 *
 *             return root;
 *         }
 *
 *         public static void preOrder(TreeNode root){
 *             if(root == null){
 *                 return;
 *             }
 *             System.out.println(root.val);
 *             preOrder(root.left);
 *             preOrder(root.right);
 *         }
 *
 *         public static void main(String[] args){
 *             int[] post = {2,4,3,1,6,7,5};
 *             int[] in = {1,2,3,4,5,6,7};
 *             TreeNode root = reConstructBinaryTree(post, in);
 *             preOrder(root);
 *         }
 * }
 */
