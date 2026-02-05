public class Heaps {
    static int[] heap = new int[100];
    static int size = 0;

    public static void insert(int val) {
        heap[size] = val;
        int i = size;
        size++;

        while(i > 0) {
            int parent = (i - 1) / 2;
            if(heap[parent] < heap[i]) {
                int temp = heap[parent];
                heap[parent] = heap[i];
                heap[i] = temp;
                i = parent;
            } else break;
        }
    }

    public static int delete() {
        if(size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        
        int deletedValue = heap[0];
        heap[0] = heap[size - 1];
        size--;

        int parent = 0;

        while(true) {
            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;
            
            //No child exists
            if(leftChild >= size ) break;
            
            //Only left child exists
            if(rightChild >= size) {
                if(heap[parent] < heap[leftChild]) {
                    int temp = heap[parent];
                    heap[parent] = heap[leftChild];
                    heap[leftChild] = temp;
                    parent = leftChild;
                } else break;
            }

            //Both Children exists
            if(heap[leftChild] > heap[rightChild] && heap[parent] < heap[leftChild]) {
                int temp = heap[parent];
                heap[parent] = heap[leftChild];
                heap[leftChild] = temp;
                parent = leftChild;
            } else if(heap[rightChild] > heap[leftChild] && heap[parent] < heap[rightChild]) {
                int temp = heap[parent];
                heap[parent] = heap[rightChild];
                heap[rightChild] = temp;
                parent = rightChild;
            } else break;
        }
        return deletedValue;
    }

    public static void display() {
        for(int i = 0; i < size; i++) {
            System.out.println(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insert(20);
        insert(5);
        insert(15);
        insert(2);
        insert(10);
        System.out.println("Max Heap: ");
        display();
        System.out.println("Deleted: " + delete());
        System.out.println("After Deletion: ");
        display();
    }
}


// import java.util.Scanner;
// public class Heaps {
//     static int[] heap = new int[100];
//     static int size = 0;

//     public static void insert(int val) {
//         heap[size] = val;
//         int i = size;
//         size++;

//         while(i > 0) {
//             int parent = (i - 1) / 2;
//             if(heap[parent] > heap[i]) {
//                 int temp = heap[parent];
//                 heap[parent] = heap[i];
//                 heap[i] = temp;
//                 i = parent;
//             } else break;
//         }
//     }

//     public static int delete() {
//         if(size == 0) {
//             System.out.println("Heap is empty");
//             return -1;
//         }
        
//         int deletedValue = heap[0];
//         heap[0] = heap[size - 1];
//         size--;

//         int parent = 0;

//         while(true) {
//             int leftChild = 2 * parent + 1;
//             int rightChild = 2 * parent + 2;
            
//             //No child exists
//             if(leftChild >= size ) break;
            
//             //Only left child exists
//             if(rightChild >= size) {
//                 if(heap[parent] > heap[leftChild]) {
//                     int temp = heap[parent];
//                     heap[parent] = heap[leftChild];
//                     heap[leftChild] = temp;
//                     parent = leftChild;
//                 } else break;
//             }

//             //Both Children exists
//             if(heap[leftChild] < heap[rightChild] && heap[parent] > heap[leftChild]) {
//                 int temp = heap[parent];
//                 heap[parent] = heap[leftChild];
//                 heap[leftChild] = temp;
//                 parent = leftChild;
//             } else if(heap[rightChild] < heap[leftChild] && heap[parent] > heap[rightChild]) {
//                 int temp = heap[parent];
//                 heap[parent] = heap[rightChild];
//                 heap[rightChild] = temp;
//                 parent = rightChild;
//             } else break;
//         }
//         return deletedValue;
//     }

//     public static void display() {
//         for(int i = 0; i < size; i++) {
//             System.out.println(heap[i] + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int choice;
//         do { 
//             System.out.println("1.Insert\n2.Delete root\n3.Diplay\n4.Exit");
//             System.out.print("Enter your choice: ");
//             choice = scanner.nextInt();
//             switch(choice) {
//                 case 1:
//                     System.out.print("Enter value to insert: ");
//                     int val = scanner.nextInt();
//                     insert(val);
//                     break;
//                 case 2: 
//                     System.out.println("Deleted value: " + delete());
//                     break;
//                 case 3:
//                     System.out.println("Heap elements: ");
//                     display();
//                     break;
//                 case 4:
//                     System.out.println("Exiting...");
//                     break;
//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//                     break;
//             }
//         } while (choice != 4);
//     }
// }

// import java.util.Scanner;
// public class Heaps {
//     public static void heapify(int arr[], int size, int parent) {
//         while(true) {
//             int leftChild = 2 * parent + 1;
//             int rightChild = 2 * parent + 2;

//             //No child exists
//             if(leftChild >= size) break;

//             //Only left child exists
//             if(rightChild >= size) {
//                 if(arr[parent] < arr[leftChild]) {
//                 int temp = arr[parent];
//                 arr[parent] = arr[leftChild];
//                 arr[leftChild] = temp;
//                 parent = leftChild;
//                 } else break;
//             }

//             //Both Children exists
//             if(arr[leftChild] > arr[rightChild] && arr[parent] < arr[leftChild]) {
//                 int temp = arr[parent];
//                 arr[parent] = arr[leftChild];
//                 arr[leftChild] = temp;
//                 parent = leftChild;
//             } else if(arr[rightChild] > arr[leftChild] && arr[parent] < arr[rightChild]) {
//                 int temp = arr[parent];
//                 arr[parent] = arr[rightChild];
//                 arr[rightChild] = temp;
//                 parent = rightChild;
//             } else break;
//         }
//     }
//     public static void heapSort(int arr[]) {
//         int size = arr.length;
//         for(int i = size / 2 - 1; i >= 0; i--) {
//             heapify(arr, size, i);
//         }
//         for(int i = size - 1; i >= 1; i--) {
//             int temp = arr[0];
//             arr[0] = arr[i];
//             arr[i] = temp;
//             heapify(arr, i, 0);
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter number of elements: ");
//         int n = sc.nextInt();
//         int arr[] = new int[n];
//         System.out.println("Enter elements: ");
//         for(int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         heapSort(arr);

//         System.out.print("Sorted array: ");
//         for(int i : arr) {
//             System.out.print(i + " ");
//         }
//     }
// }