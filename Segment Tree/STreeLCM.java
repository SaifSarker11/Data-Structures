import java.util.*;
public class STreeLCM {
    long[] segmentTree;

    public long gcd(long a, long b) {
        if(b == 0) { return a; }
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public void build(int idx, int low, int high, int[] arr) {
        if(low == high) { segmentTree[idx] = arr[low]; return; }
        int mid = (low + high) / 2;
        build(2 * idx + 1, low, mid, arr);
        build(2 * idx + 2, mid + 1, high, arr);
        segmentTree[idx] = lcm(segmentTree[2 * idx + 1], segmentTree[2 * idx + 2]);
    }

    public long query(int idx, int low, int high, int l, int r) {
        if(high < l || low > r) { return 1; } // For gcd it would return 0
        if(low >= l && high <= r) { return segmentTree[idx]; }
        int mid = (low + high) / 2;
        long left = query(2 * idx + 1, low, mid, l, r);
        long right = query(2 * idx + 2, mid + 1, high, l, r);
        return lcm(left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) { arr[i] = scanner.nextInt(); }
        STreeLCM segTree = new STreeLCM();
        segTree.segmentTree = new long[4 * n];
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