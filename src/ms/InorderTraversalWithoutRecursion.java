package ms;

import utils.TreeNode;
import utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    Print out all the nodes in a binary in order without recursion.
*/
public class InorderTraversalWithoutRecursion {

    String inorderTraversalWithoutRecursion(TreeNode root){
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        List<TreeNode> visited = new ArrayList<>();
        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            if(!visited.contains(node)) {
                visited.add(node);
                if (node.right != null) nodes.push(node.right);
                nodes.push(node);
                if (node.left != null) nodes.push(node.left);
            } else {
                sb.append(node.data + " " );
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        InorderTraversalWithoutRecursion it = new InorderTraversalWithoutRecursion();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        System.out.println("Original Tree: ");
        TreeUtils.printInOrder(root);
        System.out.println("Inorder without recursion: ");
        System.out.println(it.inorderTraversalWithoutRecursion(root));
    }
}
