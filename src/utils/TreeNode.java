package utils;

/*
    Given a tree of order n which is neither complete or a  search tree, write a function to construct a new tree of order
    m in-place. Memory usage is bound to 2 times the size of the tree. The new tree must be complete, and a node A cannot
    be a child of another node B in the new tree if A was an ancestor of B in the old tree.
 */
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    @Override
    public boolean equals(Object obj) {
        return this.data == ((TreeNode)obj).data;
    }
}
