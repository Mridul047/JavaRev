package leet.binarytree;

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

  public TreeNode getLeftNode() {
    return left;
  }

  public TreeNode getRightNode() {
    return right;
  }

  public Integer getValue() {
    return value;
  }
}
