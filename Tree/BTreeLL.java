import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
class BTreeNode {
    int data;
    BTreeNode left, right;
    BTreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class BTreeLL {
    BTreeNode root;
    Scanner sc = new Scanner(System.in);
    void createTree() {
        int val = sc.nextInt();
        root = new BTreeNode(val);
        Queue<BTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BTreeNode current = queue.poll();
            System.out.println("Left child: ");
            int leftVal = sc.nextInt();
            if(leftVal != -1) {
                current.left = new BTreeNode(leftVal);
                queue.add(current.left);
            }
            System.out.println("Right child: ");
            int rightVal = sc.nextInt();
            if(rightVal != -1) {
                current.right = new BTreeNode(rightVal);
                queue.add(current.right);
            }
        }
    }
    int height(BTreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    int depth(BTreeNode root, int key, int level) {
        if(root == null) return -1;
        if(root.data == key) return level;
        int left = depth(root.left, key, level + 1);
        if(left != -1) return left;
        return depth(root.right, key, level + 1);
    }
    int diameter(BTreeNode root) {
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }
    int width(BTreeNode root) {
        if(root == null) return 0;
        Queue<BTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxWidth = 0;
        while(!queue.isEmpty()) {
            int count = queue.size();
            maxWidth = Math.max(maxWidth, count);
            for(int i = 0; i < count; i++) {
                BTreeNode current = queue.poll();
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
        }
        return maxWidth;
    }
    void findParent(BTreeNode root, int key, BTreeNode parent) {
        if(root == null) return;
        if(root.data == key && parent != null) {
            System.out.println("Parent: " + parent.data);
        }
        findParent(root.left, key, root);
        findParent(root.right, key, root);
    }
    void printChildren(BTreeNode root, int key) {
        if(root == null) return;
        if(root.data == key) {
            System.out.println("Left Child: " + root.left.data);
            System.out.println("Right Child: " + root.right.data);
        }
    }
    boolean printAncestors(BTreeNode root, int key) {
        if(root == null) return false;
        if(root.data == key) return true;
        if(printAncestors(root.left, key) || printAncestors(root.right, key)) {
            System.out.println(root.data);
            return true;
        }
        return false;
    }
    void printDescendents(BTreeNode root, int key) {
        if(root == null) return;
        System.out.println(root.data);
        printDescendents(root.left, key);
        printAncestors(root.right, key);
    }
    boolean isBalanced(BTreeNode root) {
        if(root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(rightHeight - leftHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    boolean isBST(BTreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.data < min || root.data > max) return false;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    void spiralOrder(BTreeNode root) {
        Stack<BTreeNode> s1 = new Stack<>();
        Stack<BTreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || s2.isEmpty()) {
            while(!s1.isEmpty()) {
                BTreeNode current = s1.pop();
                System.out.println(current.data + " ");
                if(current.left != null) s2.push(current.left);
                if(current.right != null) s2.push(current.right);
            }
            while(!s2.isEmpty()) {
                BTreeNode current = s2.pop();
                System.out.println(current.data + " ");
                if(current.right != null) s1.push(current.right);
                if(current.left != null) s1.push(current.left);
            }
        }
    }
    public static void main(String[] args) {
        BTreeLL btree = new BTreeLL();
        btree.createTree();
        Scanner sc = new Scanner(System.in);
        btree.height(btree.root);
        btree.diameter(btree.root);
        btree.width(btree.root);
        btree.spiralOrder(btree.root);
        btree.isBalanced(btree.root);
        btree.isBST(btree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int key = sc.nextInt();
        btree.depth(btree.root, key, 0);
        btree.findParent(btree.root, key, null);
        btree.printChildren(btree.root, key);
        btree.printAncestors(btree.root, key);
        btree.printDescendents(btree.root, key);
    }
}
