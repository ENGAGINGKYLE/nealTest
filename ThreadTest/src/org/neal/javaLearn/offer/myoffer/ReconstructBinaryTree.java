package org.neal.javaLearn.offer.myoffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 找出根节点，然后利用递归方法构造二叉树
 */

public class ReconstructBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode reConstruct(int[] pre,int[] in){
        TreeNode root = reConstruct(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private static TreeNode reConstruct(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if(startPre>endPre || startIn>endIn){
            return null;
        }

        TreeNode node = new TreeNode(pre[startPre]);

        for(int i=startIn; i<=endIn; i++){
            if(in[i]==pre[startPre]){
                node.left = reConstruct(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                node.right = reConstruct(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }
        return node;
    }

    private static void postOrder(TreeNode node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }

    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstruct(pre,in);
        postOrder(treeNode);
    }

}
