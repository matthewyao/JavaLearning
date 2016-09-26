package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2016/8/29.
 */

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MaximumDepthofBinaryTree {

    private static TreeNode root;

    static {
        root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
    }

    public int maxDepth() {
        return subMax(root, 1);
    }

    private int subMax(TreeNode subNode,int level){
        int max = 0;
        if (subNode == null){
            return 0;
        }
        if (subNode.left == null && subNode.right == null){
            max = level;
        }
        if (subNode.left == null && subNode.right != null){
            max = subMax(subNode.right, ++level);
        }
        if (subNode.right == null && subNode.left != null){
            max = subMax(subNode.left, ++level);
        }
        if (subNode.right != null && subNode.left != null){
            max = maxNum(subMax(subNode.left, ++level), subMax(subNode.right, level));
        }
        return max;
    }

    private int maxNum(int x,int y){
        return x > y ? x : y;
    }
}
