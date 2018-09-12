package ms;

import java.util.*;

/*
    Print nodes in balanced tree level by level and reversing the print order every other level.
*/
public class ZigzagTraversal {
    List<List<TreeNode>> zigzagTraversal(TreeNode root){
        List<List<TreeNode>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean startFromRight = false;

        while(!q.isEmpty()){
            List<TreeNode> nodesAtLevel = new ArrayList<>();
            int n = q.size();
            int count = 0;
            while(count++ < n){
                TreeNode node = q.poll();
                nodesAtLevel.add(node);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(startFromRight){
                Collections.reverse(nodesAtLevel);
            }
            result.add(new ArrayList<>(nodesAtLevel));
            startFromRight = !startFromRight;
        }
        return result;
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
        ZigzagTraversal zt = new ZigzagTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        System.out.println("Original Tree: ");
        zt.printInOrder(root);
        System.out.println("\nZigzag traversal: ");
        System.out.println(zt.zigzagTraversal(root));
    }
}
