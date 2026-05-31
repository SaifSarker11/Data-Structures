import java.util.Scanner;
public class DSUCycle {
    int[] parent, size;
    public DSUCycle(int n) {
        parent = new int[n]; size = new int[n];
        for(int i = 0; i < n; i++) { parent[i] = i; size[i] = 1;}
    }
    
    public int findSet(int v) {
        if(parent[v] != v) { parent[v] = findSet(parent[v]); }
        return parent[v];
    }

    public void unionSet(int a, int b) {
        a = findSet(a); b = findSet(b);
        if(a != b) {
            if(size[a] < size[b]) { int temp = a; a = b; b = temp; }
        }
        parent[b] = a; size[a] += size[b];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); int e = scanner.nextInt();
        DSUCycle dsu = new DSUCycle(n);
        boolean hasCycle = false;
        while(e -- > 0) {
            int a = scanner.nextInt(); int b = scanner.nextInt(0);
            if(dsu.findSet(a) == dsu.findSet(b)) { hasCycle = true; }
            else { dsu.unionSet(a, b); }
        }
        scanner.close();

        if(hasCycle) { System.out.println("Graph contains a cycle."); }
        else { System.out.println("Graph does not contain a cycle."); }
    }
}