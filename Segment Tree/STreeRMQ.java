import java.util.*;
public class STreeRMQ {
    int[] segmentTree;

    public void build(int idx, int low, int high, int[] arr) {
        if(low == high) { segmentTree[idx] = arr[low]; return; }
        int mid = (low + high) / 2;
        build(2 * idx + 1, low, mid, arr);
        build(2 * idx + 2, mid + 1, high, arr);
        segmentTree[idx] = Math.max(segmentTree[2 * idx + 1], segmentTree[2 * idx + 2]);
    }

    public int query(int idx, int low, int high, int l, int r) {
        if(high < l || low > r) { return Integer.MIN_VALUE; } // For Range Minimum Query it would return Integer.MAX_VALUE
        if(low >= l && high <= r) { return segmentTree[idx]; }
        int mid = (low + high) / 2;
        int left = query(2 * idx + 1, low, mid, l, r);
        int right = query(2 * idx + 2, mid + 1, high, l, r);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) { arr[i] = scanner.nextInt(); }
        STreeRMQ segTree = new STreeRMQ();
        segTree.segmentTree = new int[4 * n];
        segTree.build(0, 0, n - 1, arr);
        int q = scanner.nextInt();
        while(q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(segTree.query(0, 0, n - 1, l, r));
        }
        scanner.close();
    }
}