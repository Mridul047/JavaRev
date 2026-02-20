package leet.binarytree;


import static leet.binarytree.BinaryTree.inOrderTraversal;
import static leet.binarytree.BinaryTree.inOrderTraversalV2;
import static leet.binarytree.BinaryTree.postOrderTraversal;
import static leet.binarytree.BinaryTree.preOrderTraversal;
import static leet.binarytree.BinaryTree.preOrderTraversalV2;

public class BinaryTreeDriver {
  static void main() {

    TreeNode root = new TreeNode(0);
    TreeNode ch1 = new TreeNode(1);
    TreeNode ch2 = new TreeNode(2);
    TreeNode ch3 = new TreeNode(3);
    TreeNode ch4 = new TreeNode(4);
    BinaryTree b1 = new BinaryTree(root);

    b1.addNodeToLeft(ch1);
    b1.addNodeToRight(ch2);

    ch1.addNodeToLeft(ch3);
    ch1.addNodeToRight(ch4);

    System.out.println("--- PreOrderTraversal Using recursive method---");
    preOrderTraversal(b1.getRootNode());
    System.out.println("--- PreOrderTraversal Using iterative method---");
    preOrderTraversalV2(b1.getRootNode());

    System.out.println("--- InOrderTraversal Using recursive method---");
    inOrderTraversal(root);
    System.out.println("--- InOrderTraversal Using iterative method---");
    inOrderTraversalV2(root);

    System.out.println("--- PostOrderTraversal Using recursive method---");
    postOrderTraversal(root);
    System.out.println("--- PostOrderTraversal Using iterative method---");
    // postOrderTraversalV2(root);
    System.out.println(getMaxHeight(root));
  }

  public static int getMaxHeight(TreeNode root){
    if(root == null) return 0;
    int maxL = getMaxHeight(root.getLeftNode());
    int maxR = getMaxHeight(root.getRightNode());
    return 1 + Math.max(maxL,maxR);
  }

  public static int getMaxValue(TreeNode root){

    return 1;
  }

}
