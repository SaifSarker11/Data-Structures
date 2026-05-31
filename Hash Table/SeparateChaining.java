import java.util.*;
public class SeparateChaining {
    LinkedList<Integer>[] table;
    int size;
    public SeparateChaining(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for(int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hash(key);
        table[index].add(key);
    }

    public void display() {
        for(int i = 0; i < size; i++) {
            System.out.println("Bucket " + i + " -> ");
            for(int val : table[i]) {
                System.out.println(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SeparateChaining hashTable = new SeparateChaining(n);
        while(true) {
            int userChoice = scanner.nextInt();
            switch(userChoice) {
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