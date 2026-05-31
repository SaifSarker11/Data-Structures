import java.util.Scanner;
class QNode {
    int data;
    QNode next;
    QNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class QueueLL {
    QNode front, rear;
    int size = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    void enqueue(int data) {
        QNode newNode = new QNode(data);
        if(front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
            size++;
        }
        if(data < min) min = data;
        if(data > max) max = data;
        System.out.println("Enqueued: " + data);
    }
    void dequeue() {
        if(front == null) {
            System.out.println("Queue Underflow");
            return;
        }
        int val = front.data;
        front = front.next;
        size--;
        if(front == null) rear = null;
        System.out.println("Dequeued: " + val);
    }
    void peek() {
        if(front == null) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }
    void getMin() {
        System.out.println("Minimum element: " + min);
    }
    void getMax() {
        System.out.println("Maximum element: " + max);
    }
    void size() {
        System.out.println("Queue size: " + size);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLL queue = new QueueLL();
        while(true) {
            String choice = sc.nextLine();
            if(choice.equals("enqueue")) {
                int data = sc.nextInt();
                queue.enqueue(data);
            }
            else if(choice.equals("dequeue")) {
                queue.dequeue();
            }
            else if(choice.equals("peek")) {
                queue.peek();
            }
            else if(choice.equals("getMin")) {
                queue.getMin();
            }
            else if(choice.equals("getMax")) {
                queue.getMax();
            }
            else if(choice.equals("size")) {
                queue.size();
            }
            else if(choice.equals("end")) {
                break;
            }
        }
    }
}
