package ms;

import utils.TreeNode;

public class NextLargestInBST {

    int findNextLargestElement(TreeNode node, int element){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        if(node.data < element){
            return findNextLargestElement(node.right, element);
        } else if(node.data >= element){}

        return 0;
    }

    public static void main(String[] args) {

    }
}
