public class DoublyLL {
    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.previous = null;

        if (head != null) {
            head.previous = node;
        }
        head = node;

        if(tail == null) {
            tail = node;
        }

        size += 1;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        node.previous = tail;
        node.next = null;

        if(tail != null) {
            tail.next = node;
        }
        tail = node;

        if(head == null) {
            head = node;
        }

        size += 1;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size - 1) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for(int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next, temp);
        temp.next.previous = node;
        temp.next = node;

        size++;
    }


    public int delete(int index) {
        Node node = get(index - 1);
        int value = node.value;
        node.next = node.next.next;
        node.next.previous = node;

        return value;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }                                                                                    

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public void displayInReverese() {
        Node node = head;
        Node last = null;

        while (node != null) {
            last = node;
            node = node.next;
        }
        
        while(last != null) {
            System.out.print(last.value + " -> ");
            last = last.previous;
        }
        System.out.println("NULL");
    }
    
    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
 