package ms;

import utils.TreeNode;
import utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class BalanceBinaryTree {
    private TreeNode balanceTree(TreeNode root) {
        TreeNode rootOther = new TreeNode(root.data);
        Queue<TreeNode> originalTree = new LinkedList<>();
        Queue<TreeNode> duplicateTree = new LinkedList<>();
        originalTree.offer(root);
        duplicateTree.offer(rootOther);

        while(!originalTree.isEmpty()){
            int n = originalTree.size();
            int count = 0;
            while(count < n){
                TreeNode node = originalTree.poll();
                if(node.left != null) {
                    originalTree.offer(node.left);
                    duplicateTree.offer(node.left);
                }
                if(node.right != null) {
                    originalTree.offer(node.right);
                    duplicateTree.offer(node.right);
                }
                count++;
            }
        }

        boolean oddMember = true;
        TreeNode temp = duplicateTree.poll();
        while(!duplicateTree.isEmpty()){
            TreeNode node = new TreeNode(duplicateTree.poll().data);
            if(oddMember){
                temp.left = node;
                originalTree.add(node);
            } else {
                temp.right = node;
                originalTree.add(node);
                if(!originalTree.isEmpty())
                    temp = originalTree.poll();
            }
            oddMember = !oddMember;
        }
        return rootOther;
    }

    public static void main(String[] args) {
        BalanceBinaryTree bt = new BalanceBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        System.out.println("Original Tree: ");
        TreeUtils.printInOrder(root);
        System.out.println("Updated Tree: ");
        TreeUtils.printInOrder(bt.balanceTree(root));
    }
}
