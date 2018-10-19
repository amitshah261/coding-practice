package utils;

public class TreeUtils {
    private static void printInOrderHelper(TreeNode root) {
        if(root != null) {
            printInOrderHelper(root.left);
            System.out.print(root + " ");
            printInOrderHelper(root.right);
        }
    }

    public static void printInOrder(TreeNode root) {
        printInOrderHelper(root);
        System.out.println();
    }

}
