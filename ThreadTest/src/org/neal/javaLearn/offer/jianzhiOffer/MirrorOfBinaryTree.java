package org.neal.javaLearn.offer.jianzhiOffer;

import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 * 8
 * / \
 * 6 10
 * / \ / \
 * 5 7 9 11
 * 镜像二叉树
 * 8
 * / \
 * 10 6
 * / \ / \
 * 11 9 7 5
 */
public class MirrorOfBinaryTree {
    //思路1：用栈结构（改成队列结构也可以），将节点依次入栈，每个入栈的节点都镜像他的子节点

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    //思路2：前序遍历的递归
    public void Mirror2(TreeNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            //创建临时节点，交换左右节点
            TreeNode tempNode = null;
            tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            Mirror2(root.left);
            Mirror2(root.right);

        }
    }

}
