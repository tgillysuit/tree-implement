import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Traversal {
  public static void main(String[] args) {
    
    TreeNode<Integer> root = new TreeNode<>(77,null, null);
    root.left = new TreeNode<>(22, null, null);
    root.right = new TreeNode<>(87, null, null);
    root.right.left = new TreeNode<>(9, null, null);
    root.left.right = new TreeNode<>(33, null, null);
    root.left.left = new TreeNode<>(4, null, null);

    TreeNode<String> stringRoot = new TreeNode<>("Hello", null, null);
    stringRoot.left = new TreeNode<>("Hi", null, null);
    stringRoot.right = new TreeNode<>("Hey", null, null);

    // TreeNode<Integer> megaRoot = new TreeNode<>(0, null, null);

    // TreeNode<Integer> current = megaRoot;
    // for (int i = 0; i <= 999999; i++) {
    //   current.left = new TreeNode<>(i, null, null);
    //   current = current.left;
    // }

    // System.out.println(toSet(root));
    printLevelOrder(root);

    // System.out.println("Pre-order:");
    // preOrderIter(root);
    // System.out.println("Post-order:");
    // postOrder(root);
    // System.out.println("Inorder:");
    // inOrder(root);
    // System.out.println("Greater Than:");
    // greaterThan(root, 25);
    // System.out.println("Count Nodes: " + countNodes(root));
    // inOrder(stringRoot);
  }

  public static Set<Integer> toSet(TreeNode<Integer> node) {
    Set<Integer> result = new HashSet<>();

    // add everything to the set
    toSet(node, result);

    System.out.println(result);

    return result;
  }

  // Helper method for toSet
  // add everything to the set
  public static void toSet(TreeNode<Integer> node, Set<Integer> result) {
    if (node == null) return;

    result.add(node.value);
    toSet(node.left, result);
    toSet(node.right, result);
  }

  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> nodeStack = new Stack<>();

    nodeStack.push(node);

    while (!nodeStack.empty()){
      TreeNode<T> current = nodeStack.pop();

      if (current == null) {
        continue;
      }
      System.out.println(current.value);
      nodeStack.push(current.right);
      nodeStack.push(current.left);
    }
  }

  public static <T> void printLevelOrder(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();

    queue.add(node);

    while(!queue.isEmpty()) {
      TreeNode<T> current = queue.poll();
      if (current == null) continue;

      System.out.println(current.value);
      queue.add(current.left);
      queue.add(current.right);
    }
  }

  public static <T> void preOrder(TreeNode<T> node) {
    if (node == null) return;
    System.out.println(node.value); // root
    preOrder(node.left);
    preOrder(node.right);
  }

  public static <T> void postOrder(TreeNode<T> node) {
    if (node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.value); // root
  }

  public static <T> void inOrder(TreeNode<T> node) {
    if (node == null) return;
    inOrder(node.left);
    System.out.println(node.value); // root
    inOrder(node.right);
  }

  public static void greaterThan(TreeNode<Integer> node, int threshold) {
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

  public static <T> int countNodes(TreeNode<T> node) {
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

  public static <T> int countLevels(TreeNode<T> node) {
    // if null return 0
    if (node == null) return 0;
    // height of larger subtree + 1
    int leftHeight = countLevels(node.left);
    int righteight = countLevels(node.right);
    int biggerHeight = Math.max(leftHeight, righteight);

    return biggerHeight + 1;
  }

  // null -> true
  public static boolean allOdd(TreeNode<Integer> node) {
    if (node == null) return true;
    // node.value is even -> false
    // allOdd left and right -> true else false
    return node.value % 2 != 0 && 
    allOdd(node.right) && allOdd(node.right);
  }

}