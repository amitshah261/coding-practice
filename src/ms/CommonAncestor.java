package ms;

/*
    Find Lowest Common Ancestor for two nodes in a Binary Tree and BinarySearchTree
*/
public class CommonAncestor {

    private TreeNode findCommonAncestorInBinaryTree(TreeNode root, int value1, int value2){
        if(root == null){
            return null;
        }
        if(root.data == value1 || root.data == value2){
            return root;
        }
        boolean isValue1OnLeft = findNode(root.left, value1);
        boolean isValue2OnLeft = findNode(root.left, value2);

        if(isValue1OnLeft != isValue2OnLeft){
            return root;
        }

        if(isValue1OnLeft){
            return findCommonAncestorInBinaryTree(root.left, value1, value2);
        } else {
            return findCommonAncestorInBinaryTree(root.right, value1, value2);
        }
    }

    private TreeNode findCommonAncestorInBinarySearchTree(TreeNode root, int value1, int value2){
        if(root == null){
            return null;
        }
        else if(root.data == value1 || root.data == value2 || root.data > value1 && root.data < value2){
            return root;
        }
        else if(root.data > value2){
            return findCommonAncestorInBinaryTree(root.left, value1, value2);
        } else {
            return findCommonAncestorInBinaryTree(root.right, value1, value2);
        }
    }

    private TreeNode findLowestCommonAncestor(TreeNode root, int value1, int value2){
        boolean value1Exists = findNode(root, value1);
        boolean value2Exists = findNode(root, value2);

        if(!value1Exists || !value2Exists){
            if(!value1Exists) System.err.println("Value: '" + value1 +"' is not present in the tree");
            if(!value2Exists) System.err.println("Value: '" + value2 +"' is not present in the tree");
            System.err.println("Please enter nodes that are present in the tree");
            return null;
        }

//        return findCommonAncestorInBinarySearchTree(root, value1, value2);
        return findCommonAncestorInBinaryTree(root, value1, value2);
    }

    private boolean findNode(TreeNode root, int value) {
        if(root == null){
            return false;
        }
        else if(root.data == value){
            return true;
        }

        return findNode(root.left, value) || findNode(root.right, value);
    }

    private void printInOrder(TreeNode root) {
        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.print(" " + root);
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        CommonAncestor ca = new CommonAncestor();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        System.out.println("Original Tree: ");
        ca.printInOrder(root);
        int value1 = 4, value2 = 6;
        System.out.println("\nCommon Ancestor for values: " + value1 + " and value2: " + value2);
        System.out.println(ca.findLowestCommonAncestor(root, value1, value2));
        value1 = 3; value2 = 6;
        System.out.println("\nCommon Ancestor for values: " + value1 + " and value2: " + value2);
        System.out.println(ca.findLowestCommonAncestor(root, value1, value2));
        value1 = 100000; value2 = 4;
        System.out.println("\nCommon Ancestor for values: " + value1 + " and value2: " + value2);
        System.out.println(ca.findLowestCommonAncestor(root, value1, value2));
    }
}
