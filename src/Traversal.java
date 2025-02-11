

public class Traversal {
  public static void main(String[] args) {
    
    TreeNode root = new TreeNode(77,null, null);
    root.left = new TreeNode(22, null, null);
    root.right = new TreeNode(86, null, null);
    root.right.left = new TreeNode(9, null, null);
    root.left.right = new TreeNode(33, null, null);
    root.left.right.left = new TreeNode(86, null, null);

    System.out.println("Pre-order:");
    preOrder(root);
    System.out.println("Post-order:");
    postOrder(root);
    System.out.println("Inorder:");
    inOrder(root);
    System.out.println("Greater Than:");
    greaterThan(root, 25);
    System.out.println("Count Nodes: " + countNodes(root));
    

  }

  public static void preOrder(TreeNode node) {
    if (node == null) return;
    System.out.println(node.value); // root
    preOrder(node.left);
    preOrder(node.right);
  }

  public static void postOrder(TreeNode node) {
    if (node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.value); // root
  }

  public static void inOrder(TreeNode node) {
    if (node == null) return;
    inOrder(node.left);
    System.out.println(node.value); // root
    inOrder(node.right);
  }

  public static void greaterThan(TreeNode node, int threshold) {
    /*
    if null return
    if node.value > 50
      print node.value
    greaterThan50(node.left)
    greaterThan50(mode.right)
     */
    if (node == null) return;
    if (node.value > threshold) System.out.println(node.value);
    greaterThan(node.left, threshold);
    greaterThan(node.right, threshold);
  }

  public static int countNodes(TreeNode node) {
    /*
    if null return 0
    count = 1
    count = count + # of nodes in left countNodes(node.left)
    count = count + # of nodes in the right countNodes(node.right)
     */
    if (node == null) return 0;
    int count = 1; // count current node
    count += countNodes(node.left); // count left subtree
    count += countNodes(node.right); // count right subtree
    return count;
  }
}