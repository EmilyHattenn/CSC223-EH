package csc223.eh;

// Recognize that you can also use a LinkedList of TreeNodes to implement the Queue.
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements Tree {

    protected TreeNode root;
    protected int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    // Implement the levelOrder method
    public String levelOrder() {
        return levelOrderHelper(root);

    }

    private String levelOrderHelper(TreeNode node) {
        // base case: if the node is null, then return an empty string
        if (node == null) return "";
        // create a queue to store the nodes
        Queue<TreeNode> queue = new LinkedList<>();
        // add the root node to the queue
        queue.add(node);
        // create a string to store the level order traversal
        StringBuilder sb = new StringBuilder();
        // while the queue is not empty
        while (!queue.isEmpty()) {
            // remove the front node from the queue
            TreeNode current = queue.remove();
            // append the data of the current node to the string
            sb.append(current.data);
            // if the left child is not null, then add it to the queue
            if (current.left != null) {
                queue.add(current.left);
            }
            // if the right child is not null, then add it to the queue
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        // return the level order traversal
        return sb.toString();

    }

    @Override
    public String inOrder() {
        // calls the recursive helper method to get the inorder traversal of the tree
        return inorderHelper(root);
    }

    private String inorderHelper(TreeNode node) {
        // base case: if the node is null, then return an empty string
        if (node == null) return "";
        // left -> root -> right
        return inorderHelper(node.left) + node.data + inorderHelper(node.right);
    }

    @Override
    public String preOrder() {
        // calls the recursive helper method to get the preorder traversal of the tree
        return preorderHelper(root);
    }

    private String preorderHelper(TreeNode node) {
        // base case: if the node is null, then return an empty string
        if (node == null) return "";
        // root -> left -> right
        return node.data + preorderHelper(node.left) + preorderHelper(node.right);
    }

    @Override
    public String postOrder() {
        return postorderHelper(root);
    }

    private String postorderHelper(TreeNode node) {
        if (node == null) return "";
        return postorderHelper(node.left) + postorderHelper(node.right) + node.data;
    }

    @Override
    public void insert(char item) {
        TreeNode newNode = new TreeNode(item);
        if (root == null) {
            root = newNode;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();

                // Insert at first available left child
                if (temp.left == null) {
                    temp.left = newNode;
                    break;
                } else {
                    queue.add(temp.left);
                }

                // Insert at first available right child
                if (temp.right == null) {
                    temp.right = newNode;
                    break;
                } else {
                    queue.add(temp.right);
                }
            }
        }
        size++; // Update size after insertion
    }


    @Override
    public boolean search(char item) {
        // use level order traversal to search for the item
        return searchHelper(root, item);
    }

    private boolean searchHelper(TreeNode node, char item) {
        // base case: if the node is null, then return false
        if (node == null) return false;
        // if the item is found, then return true
        if (node.data == item) return true;
        // recursively search the left and right subtrees
        return searchHelper(node.left, item) || searchHelper(node.right, item);
    }   

    @Override
    public int size() {
        // calls the recursive helper method to get the size of the tree
        return sizeHelper(root);
    }

    private int sizeHelper(TreeNode node) {
        // base case: if the node is null, then return 0
        if (node == null) return 0;
        // recursively get the size of the left and right subtrees
        return 1 + sizeHelper(node.left) + sizeHelper(node.right);
    }

    @Override
    public boolean isEmpty() {
        // checks if the root is null
        return root == null;
    }

    @Override
    public int height() {
        // calls the recursive helper method to get the height of the tree
        return heightHelper(root);
    }

    // Recursive helper method to get the height of the tree
    private int heightHelper(TreeNode node) {
        // base case: if the node is null, then return 0
        if (node == null) return 0;
        // recursively get the height of the left and right subtrees
        return 1 + Math.max(heightHelper(node.left), heightHelper(node.right));
    }

}
    