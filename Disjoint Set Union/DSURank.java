import java.util.ArrayList;
import java.util.Scanner;
public class DSURank {
    ArrayList<Integer> parent, rank;
    public DSURank(int n) {
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        for(int i = 0; i <= n; i++) { parent.add(i); rank.add(0); }
    }

    public int findSet(int v) {
        if(!parent.get(v).equals(v)) { parent.set(v, findSet(parent.get(v).intValue())); }
        return parent.get(v);
    }

    public void unionSet(int a, int b) {
        a = findSet(a); b = findSet(b);
        if(a != b) {
            if(rank.get(a) < rank.get(b)) { int temp = a; a = b; b = temp; }
            parent.set(b, a);
            if(rank.get(a).equals(rank.get(b))) { rank.set(a, rank.get(a) + 1); }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); int q = scanner.nextInt();
        DSURank dsu = new DSURank(n);
        while(q-- > 0) {
            int a = scanner.nextInt(); int b = scanner.nextInt();
            dsu.unionSet(a, b);
        }
        scanner.close();
        for(int i = 0; i <= n; i++) { System.out.println("Node " + i + " -> Parent: " + dsu.findSet(i)); }
    }
}