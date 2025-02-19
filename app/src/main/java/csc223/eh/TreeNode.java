package csc223.eh;

public class TreeNode extends Node {
    TreeNode left;
    TreeNode right;

    public TreeNode(char data) {
        super(data);
        this.left = this.right = null;
    }
}