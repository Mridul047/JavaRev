package leet.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTree {

  private TreeNode root;

  public BinaryTree(TreeNode root) {
    this.root = root;
  }

  public void addNodeToLeft(TreeNode node) {
    root.addNodeToLeft(node);
  }

  public void addNodeToRight(TreeNode node) {
    root.addNodeToRight(node);
  }

  public TreeNode getRootNode() {
    return root;
  }

  private void traverseLeftOfNode(TreeNode root) {}

  public static void preOrderTraversal(TreeNode root) {
    if (root == null) return;
    System.out.println(root.getValue() + " ");
    preOrderTraversal(root.getLeftNode());
    preOrderTraversal(root.getRightNode());
  }

  public static void preOrderTraversalV2(TreeNode root) {
    if (root == null) return;

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode tempNode = stack.pop();
      System.out.println(tempNode.getValue());
      if (tempNode.getRightNode() != null) stack.push(tempNode.getRightNode());
      if (tempNode.getLeftNode() != null) stack.push(tempNode.getLeftNode());
    }
  }

  public static void inOrderTraversal(TreeNode root) {
    if (root == null) return;
    inOrderTraversal(root.getLeftNode());
    System.out.println(root.getValue());
    inOrderTraversal(root.getRightNode());
  }

  public static void inOrderTraversalV2(TreeNode root) {
    if (root == null) return;
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode tempNode = root;

    while (!stack.isEmpty() || tempNode != null) {
      if (tempNode != null) {
        stack.push(tempNode);
        tempNode = tempNode.getLeftNode();
      } else {
        tempNode = stack.pop();
        System.out.println(tempNode.getValue());
        tempNode = tempNode.getRightNode();
      }
    }
  }

  public static void postOrderTraversal(TreeNode root) {
    if (root == null) return;
    postOrderTraversal(root.getLeftNode());
    postOrderTraversal(root.getRightNode());
    System.out.println(root.getValue());
  }

  public static void postOrderTraversalV2(TreeNode root) {}
}
