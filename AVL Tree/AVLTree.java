import java.util.Scanner;
class Node {
    int data, height; Node left, right;
    Node (int data) { this.data = data; this.height = 1; }
}

public class AVLTree {
    Node root;

    public int height(Node node) { return (node == null) ? 0 : node.height; }

    public int balanceFactor(Node node) { return (node == null) ? 0 : height(node.left) - height(node.right); }

    public Node leftRotate(Node x) {
        Node y = x.right; Node t = y.left; y.left = x; x.right = t;
        
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    public Node rightRotate(Node y) {
        Node x = y.left; Node t = x.right; x.right = y; y.left = t;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return x;
    }

    public Node insert(Node node, int keyVal) {
        if(node == null) return new Node(keyVal);
        if(keyVal < node.data) node.left = insert(node.left, keyVal);
        else if(keyVal > node.data) node.right = insert(node.right, keyVal);
        else return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        if(balance > 1 && keyVal < node.left.data) return rightRotate(node); //LL
        if(balance < -1 && keyVal > node.right.data) return leftRotate(node); //RR
        if(balance > 1 && keyVal > node.left.data) { //LR
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance < -1 && keyVal < node.right.data) { //RL
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public Node min(Node node) {
        while(node.left != null) node = node.left;
        return node;
    }

    public Node delete(Node node, int keyVal) {
        if(node == null) return node;
        if(keyVal < node.data) { node.left = delete(node.left, keyVal); }
        else if(keyVal > node.data) { node.right = delete(node.right, keyVal); }
        else {
            if(node.left == null && node.right == null) { node = null; } 
            else if(node.left == null) { node = node.right; }
            else if(node.right == null) { node = node.left; }
            else {
                Node temp = min(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }

        if(node == null) return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        if(balance > 1 && balanceFactor(node.left) >= 0) { return rightRotate(node); }
        if(balance < -1 && balanceFactor(node.right) <= 0) { return leftRotate(node); }
        if(balance > 1 && balanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance < -1 && balanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            System.out.println(node.data + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree avlTree = new AVLTree();
        while(true) {
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    int i_val = scanner.nextInt();
                    avlTree.root = avlTree.insert(avlTree.root, i_val);
                    break;
                case 2:
                    int d_val = scanner.nextInt();
                    avlTree.root = avlTree.delete(avlTree.root, d_val);
                    break;
                case 3:
                    avlTree.inorder(avlTree.root);
                    break;
                default:
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}