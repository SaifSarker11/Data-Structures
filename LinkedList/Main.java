public class Main {
    public static void main(String[] args) {
        // LL list = new LL();
        // list.insertFirst(3);
        // list.insertFirst(2);
        // list.insertFirst(8);
        // list.insertFirst(17);
        // list.insertLast(99);
        // list.insert(100, 3);
        // list.display();
        // System.out.println(list.deleteFirst());
        // list.display();
        // System.out.println(list.deleteLast());
        // list.display();
        // System.out.println(list.delete(2));
        // list.display();
        // list.update(2, 10);
        // list.display();

        // DoublyLL dlist = new DoublyLL();
        // dlist.insertFirst(3);
        // dlist.insertFirst(2);
        // dlist.insertFirst(8);
        // dlist.insertFirst(17);
        // dlist.insertLast(10);
        // dlist.display();
        // dlist.insert(4, 2);
        // dlist.display();
        // System.out.print("Doubly linked list in reverse: ");
        // dlist.displayInReverese();
        // dlist.delete(3);
        // dlist.display();

        // CircularLL cll = new CircularLL();
        // cll.insert(8);
        // cll.insert(9);
        // cll.insert(2);
        // cll.insert(7);
        // cll.insert(17);
        // cll.display();
        // cll.delete(7);
        // cll.display();

        Spotify sll = new Spotify();
        sll.insertSong("All Falls Down");
        sll.insertSong("There You Are");
        sll.insertSong("Hymn For the Weekend");
        sll.display();
        sll.playNext();
        sll.playPrev();
    }
}
