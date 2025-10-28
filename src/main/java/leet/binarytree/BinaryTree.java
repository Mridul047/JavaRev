package leet.binarytree;

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

  private void traverseLeftOfNode(TreeNode root) {}
}

class TreeNode {
  private Integer value;
  private TreeNode left;
  private TreeNode right;

  public TreeNode() {}

  public TreeNode(Integer value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public TreeNode(Integer value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public void addNodeToLeft(TreeNode inputNode) {
    left = inputNode;
  }

  public void addNodeToRight(TreeNode inputNode) {
    right = inputNode;
  }
}
