import java.util.*;
public class LazySum {
    int[] segmentTree, lazy;
    int n;
    public LazySum (int arr[]) {
        n = arr.length;
        segmentTree = new int[4 * n];
        lazy = new int[4 * n];
        build(0, 0, n - 1, arr);
    }

    public void build(int idx, int low, int high, int[] arr) {
        if(low == high) { segmentTree[idx] = arr[low]; return; }
        int mid = (low + high) / 2;
        build(2 * idx + 1, low, mid, arr);
        build(2 * idx + 2, mid + 1, high, arr);
        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
    }

    public void push(int idx, int low, int high) { //lazy propagation
        if(lazy[idx] != 0) { //lazy update pending
            segmentTree[idx] += (high - low + 1) * lazy[idx]; // for RMQ, segmentTree[idx] += lazy[idx]
            if(low != high) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0; //lazy update completed, and distributed to its left and right children
        }
    }

    public void updateRange(int idx, int low, int high, int l, int r, int val) {
        push(idx, low, high);
        if(high < l || low > r) return; // no overlap
        if(low >= l && high <= r) { // total overlap
            lazy[idx] += val;
            push(idx, low, high);
            return;
        }
        //partially overlap
        int mid = (low + high) / 2;
        updateRange(2 * idx + 1, low, mid, l, r, val);
        updateRange(2 * idx + 2, mid + 1, high, l, r, val);
        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
    }

    public void updatePoint(int idx, int low, int high, int pos, int val) {
        push(idx, low, high);
        if(low == high) { segmentTree[idx] += val; return; }
        int mid = (low + high) / 2;
        if(pos <= mid) updatePoint(2 * idx + 1, low, mid, pos, val);
        else updatePoint(2 * idx + 2, mid + 1, high, pos, val);
        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
    }

    public int query(int idx, int low, int high, int l, int r) {
        push(idx, low, high);
        if(high < l || low > r) { return 0; } // for Range Maximum Query, it would return INTEGER.MIN_VALUE and for Range Minimum Query, it would return INTEGER.MAX_VALUE
        if(low >= l && high <= r) { return segmentTree[idx]; }
        int mid = (low + high) / 2;
        int left = query(2 * idx + 1, low, mid, l, r);
        int right = query(2 * idx + 2, mid + 1, high, l, r);
        return left + right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        LazySum segTree = new LazySum(arr);
        int q = scanner.nextInt();
        while(q-- > 0) {
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    System.out.println(segTree.query(0, 0, n - 1, l, r));
                    break;
                case 2:
                    int pos = scanner.nextInt();
                    int val = scanner.nextInt();
                    segTree.updatePoint(0, 0, n - 1, pos, val);
                    break;
                case 3:
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    int value = scanner.nextInt();
                    segTree.updateRange(0, 0, n - 1, a, b, value);
                    break;
                default:
                    System.out.println("Please enter an integer value among 1, 2, and 3");
            }
        }
        scanner.close();
    }
}
