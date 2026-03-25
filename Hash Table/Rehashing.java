import java.util.*;
public class Rehashing {
    int[] table;
    int size;
    int count = 0;
    public Rehashing(int size) {
        this.size = size;
        this.table = new int[size];
        Arrays.fill(table, -1);
    }

    public int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        double loadFactor = (double) count / size;
        if(loadFactor >= 0.75) { rehash(); }
        for(int i = 0; i < size; i++) {
            int newIndex = (hash(key) + i) % size;
            if(table[newIndex] == -1) {
                table[newIndex] = key;
                count++;
                return;
            }
        }
    }

    public void rehash() {
        int oldSize = size;
        int[] oldTable = table;

        size = size * 2;
        table = new int[size];
        Arrays.fill(table, -1);
        count = 0;

        for(int i = 0; i < oldSize; i++) {
            if(oldTable[i] != -1) { insert(oldTable[i]); }
        }
    }

    public void display() {
        for(int i = 0; i < size; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Rehashing hashTable = new Rehashing(n);
        while(true) {
            int choice = scanner.nextInt();
            switch(choice) {
                case 1: 
                    int key = scanner.nextInt();
                    hashTable.insert(key);
                    break;
                case 2:
                    hashTable.display();
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
} 