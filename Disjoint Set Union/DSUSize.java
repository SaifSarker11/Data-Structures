import java.util.ArrayList;
import java.util.Scanner;
public class DSUSize {
    ArrayList<Integer> parent, size;
    public DSUSize(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i = 0; i <= n; i++) { parent.add(i); size.add(1); }
    }

    public int findSet(int v) {
        if(!parent.get(v).equals(v)) { parent.set(v, findSet(parent.get(v).intValue())); }
        return parent.get(v);
    }

    public void unionSet(int a, int b) {
        a = findSet(a); b = findSet(b);
        if(a != b) {
            if(size.get(a) < size.get(b)) { int temp = a; a = b; b = temp; }
            parent.set(b, a); size.set(a, size.get(a) + size.get(b));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); int q = scanner.nextInt();
        DSUSize dsu = new DSUSize(n);
        while(q-- > 0) {
            int a = scanner.nextInt(); int b = scanner.nextInt();
            dsu.unionSet(a, b);
        }
        scanner.close();
        for(int i = 0; i <= n; i++) { System.out.println("Node " + i + " -> Parent: " + dsu.findSet(i)); }
    }
}