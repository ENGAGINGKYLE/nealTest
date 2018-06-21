package org.neal.javaLearn.offer.jianzhiOffer;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

import java.util.Stack;

public class BinaryConvertLinkedList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：直接用递归中序遍历
     */
    TreeNode head = null;
    TreeNode realHead = null;//双向链表的头结点

    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert1(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        Convert1(pRootOfTree.right);
        return realHead;
    }

    /**
     * 方法2： 非递归
     */
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return pRootOfTree;

        TreeNode list = null;
        Stack<TreeNode> s = new Stack<>();
        while (pRootOfTree != null || !s.isEmpty()) {
            if (pRootOfTree != null) {
                s.push(pRootOfTree);
                pRootOfTree = pRootOfTree.right;
            } else {
                pRootOfTree = s.pop();
                if (list == null)
                    list = pRootOfTree;
                else {
                    list.left = pRootOfTree;
                    pRootOfTree.right = list;
                    list = pRootOfTree;
                }
                pRootOfTree = pRootOfTree.left;
            }
        }

        return list;
    }
}
