import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class StackLL {
    Node top, minTop;
    int size = 0;
    void push(int data) {
        Node newTop = new Node(data);
        newTop.next = top;
        top = newTop;
        size++;
        if(minTop == null || data <= minTop.data) {
            Node newMinTop = new Node(data);
            newMinTop.next = minTop;
            minTop = newMinTop;
        }
        System.out.println("Pushed: " + data);
    }
    void pop() {
        if(top == null) {
            System.out.println("Stack Underflow");
            return;
        }
        int val = top.data;
        top = top.next;
        size--;
        if(minTop != null && val == minTop.data) {
            minTop = minTop.next;
        }
        System.out.println("Popped: " + val);
    }
    void top() {
        if(top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element: " + top.data);
        }
    }
    void getMin() {
        if(minTop == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Minimum element: " + minTop.data);
        }
    }
    void size() {
        System.out.println("Stack size: " + size);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackLL stack = new StackLL();
        while(true) {
            String choice = sc.nextLine();
            if(choice.equals("push")) {
                int data = sc.nextInt();
                sc.nextLine();
                stack.push(data);
            }
            else if(choice.equals("pop")) {
                stack.pop();
            }
            else if(choice.equals("top")) {
                stack.top();
            }
            else if(choice.equals("getMin")) {
                stack.getMin();
            }
            else if(choice.equals("size")) {
                stack.size();
            }
            else if(choice.equals("end")) {
                break;
            }
            }
        }
}
