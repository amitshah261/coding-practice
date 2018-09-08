import java.util.LinkedList;
import java.util.Queue;

/*
    Given a tree of order n which is neither complete or a  search tree, write a function to construct a new tree of order
    m in-place. Memory usage is bound to 2 times the size of the tree. The new tree must be complete, and a node A cannot
    be a child of another node B in the new tree if A was an ancestor of B in the old tree.
 */

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
    }

    @Override
    public String toString(){
        return String.valueOf(data);
    }
}
public class BalanceBinaryTree {
    TreeNode balanceTree(TreeNode root){
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

    void printInOrder(TreeNode root){
        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.print(" " + root);
        printInOrder(root.right);
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
        bt.printInOrder(root);
        System.out.println("\nUpdated Tree: ");
        bt.printInOrder(bt.balanceTree(root));
    }
}
