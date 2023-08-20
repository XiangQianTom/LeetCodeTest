package utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();

            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.offer(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    // 先序遍历
    public void preorderTraversal() {
        preorderTraversal(this);
    }

    // 先序遍历
    private void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // 中序遍历
    public void inorderTraversal() {
        inorderTraversal(this);
    }

    // 中序遍历
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    // 后序遍历
    public void postorderTraversal() {
        postorderTraversal(this);
    }

    // 后序遍历
    private void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public void printTree() {
        printTree(this);
        System.out.println();
    }

    private void printTree(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.val + " ");
        if (null != root.left) {
            System.out.print(root.left.val + " ");
        }
        if (null != root.right) {
            System.out.print(root.right.val + " ");
        }
        if (null != root.left) {
            printTree(root.left.left);
            printTree(root.left.right);
        }
        if (null != root.right) {
            printTree(root.right.left);
            printTree(root.right.right);
        }
    }
}