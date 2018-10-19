package ms;

import utils.TreeNode;
import utils.TreeUtils;

/*
    Given root node to a binary tree, reconstruct (clone) it and return its root node
 */
public class CloneBinaryTree {
    void cloneTree(TreeNode root, TreeNode cloneRoot){
        if(root == null) {
            return;
        }
        if(root.left != null){
            cloneRoot.left = new TreeNode(root.left.data);
        }

        if(root.right != null){
            cloneRoot.right = new TreeNode(root.right.data);
        }

        cloneTree(root.left, cloneRoot.left);
        cloneTree(root.right, cloneRoot.right);
    }

    TreeNode cloneTree(TreeNode root){
        if(root == null){
            return root;
        }
        TreeNode clone = new TreeNode(root.data);

        cloneTree(root, clone);

        return clone;
    }

    public static void main(String[] args) {
        CloneBinaryTree ct = new CloneBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        TreeUtils.printInOrder(root);
        TreeUtils.printInOrder(ct.cloneTree(root));
    }
}
