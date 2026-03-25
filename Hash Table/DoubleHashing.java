import java.util.*;
public class DoubleHashing {
    int[] table;
    int size;
    public DoubleHashing(int size) {
        this.size = size;
        table = new int[size];
        Arrays.fill(table, -1);
    }

    public int hash1(int key) {
        return key % size;
    }

    public int hash2(int key) {
        return 1 + key % (size - 1);
    }

    public void insert(int key) {
        for(int i = 0; i < size; i++) {
            int newIndex = (hash1(key) + i * hash2(key)) % size;
            if(table[newIndex] == -1) {
                table[newIndex] = key;
                return;
            }
        }
    }

    public void display() {
        for(int i = 0; i < size; i++) {
            if(table[i] != -1) {
                System.out.println(i + ": " + table[i]);
        }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DoubleHashing hashTable = new DoubleHashing(n);
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