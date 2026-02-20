import java.util.*;
public class RangeMaxQuery {
    static int st[][];
    static int log[];
    public static void buildSparseTable(int[] arr) {
        int n = arr.length;
        int k = (int)(Math.log(n) / Math.log(2)) + 1;
        st = new int[n + 10][k + 10];
        for(int i = 0; i < n; i++) st[i][0] = arr[i];
        for(int j = 1; j < k; j++) {
            for(int i = 0; i + (1 << j) <= n; i++) {
                st[i][j] = Math.max(st[i][j -1], st[i + (1 << (j -1))][j -1]);
            }
        }
        log = new int[n + 10];
        log[1] = 0;
        for(int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }
    }
    public static int query(int l, int r) {
        int j = log[r - l + 1];
        return Math.max(st[l][j], st[r - (1 << j) + 1][j]);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int arr[] = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        buildSparseTable(arr);
        while(q != 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(query(l, r));
            q--;
        }
        scanner.close();
    }
}