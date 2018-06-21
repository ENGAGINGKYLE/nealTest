package org.neal.javaLearn.offer.jianzhiOffer;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

public class PostOrderOfBinaryTree {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length ==0){
            return false;
        }
        return VerifySquenceOfBST1(sequence,0,sequence.length-1);
    }

    public static boolean VerifySquenceOfBST1(int[] sequence,int start,int end) {

        if(start > end)
            return true;
        int root=sequence[end];//后序遍历最后一个节点为根节点

        //在二叉搜索树中左子树节点小于根节点
        int i=0;
        for(;i<end;i++){
            if(sequence[i]>root){
                break;
            }
        }

        //在二叉搜索树中右子树节点大于根节点
        int j=i;
        for(;j<end;j++){
            if(sequence[j]<root)
                return false;
        }
        boolean left=true;
        boolean right=true;
        if(i>start){
            left=VerifySquenceOfBST1(sequence,start,i-1);
        }
        if(i<sequence.length-1)
            right=VerifySquenceOfBST1(sequence,i,end-1);
        return (left&&right);

    }
}
