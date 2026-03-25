import java.util.*;
public class QuadraticProbing {
    int[] table;
    int size;
    public QuadraticProbing(int size) {
        this.size = size;
        table = new int[size];
        Arrays.fill(table, -1);
    }

    public int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        for(int i = 0; i < size; i++) {
            int newIndex = (hash(key) + i * i) % size;
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
        QuadraticProbing hashTable = new QuadraticProbing(n);
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