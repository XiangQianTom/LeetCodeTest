package utils;

public class TreeNodeUtils {
    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return buildTreeHelper(array, 0);
    }

    private static TreeNode buildTreeHelper(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(array[index]);
        root.left = buildTreeHelper(array, 2 * index + 1);
        root.right = buildTreeHelper(array, 2 * index + 2);
        return root;
    }
}
