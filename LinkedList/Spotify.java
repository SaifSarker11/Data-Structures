public class Spotify {
    private Node head;
    private Node tail;
    private int size;

    public void insertSong(String name) {
        Node node = new Node(name);
        if(head == null) {
            head = node;
            tail = node;
            node.next = node;
            node.prev = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        node.next = head;
        head.prev = node;
        tail = node;

        size++;
    }

    public void display() {
        Node node = head;
        if (head != null) {
            do { 
                System.out.print(node.name + " ->");
                node = node.next;
            } while (node != head);
        }
        System.out.println(head.name);
    }

    public void playNext() {
        Node currentNode = head;
        do {
            System.out.println("Current song is: " + currentNode.name);
            System.out.println("Next Song is: " + currentNode.next.name);
            currentNode = currentNode.next;
        } while(currentNode != tail);

        if(currentNode == tail) {
            System.out.println("Current song is: " + currentNode.name);
            currentNode.next = head;
            System.out.println("Next song is: " + currentNode.next.name);
        }
    }

    public void playPrev() {
        Node currentNode = tail;
        do {
            System.out.println("Current song is: " + currentNode.name);
            System.out.println("Previous Song was: " + currentNode.prev.name);
            currentNode = currentNode.prev;
        } while(currentNode != head);

        if(currentNode == head) {
            System.out.println("Current song is: " + currentNode.name);
            currentNode.prev = tail;
            System.out.println("Next song is: " + currentNode.prev.name);
        }
    }

    private class Node {
        private String name;
        private Node next;
        private Node prev;

        public Node(String name) {
            this.name = name;
        }

        public Node(String name, Node next, Node prev) {
            this.name = name;
            this.next = next;
            this.prev = prev;
        }
    }
}
