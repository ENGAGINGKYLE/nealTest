package org.neal.javaLearn.offer.jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPathOfTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return pathList;
        Stack<Integer> stack = new Stack<Integer>();
        FindPath(root, target, stack, pathList);
        return pathList;

    }

    private void FindPath(TreeNode root, int target, Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
        if (root == null)
            return;
        //如果是叶子节点，判断值是否是目标值
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i : path) {
                    list.add(new Integer(i));
                }
                list.add(new Integer(root.val));
                pathList.add(list);
            }
        } else {//不是叶子节点就遍历其子节点
            path.push(new Integer(root.val));
            //是按照前序遍历的方式查找路径，如果向上退出到父节点时，要回到target值，而不是target-root.val
            FindPath(root.left, target - root.val, path, pathList);
            FindPath(root.right, target - root.val, path, pathList);
            path.pop();
        }

    }
}
