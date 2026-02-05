import java.util.*;
class Edge {
    int src;
    int dest;
    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}
public class GraphLL {
    int V;
    ArrayList<Edge>graph[];
    GraphLL(int V) {
        this.V = V;
        graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
    }
    void createGraph() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            if(src == -1 && dest == -1) break;
        graph[src].add(new Edge(src, dest));
        graph[dest].add(new Edge(dest, src));
        }
    }
    void display() {
        for(int i = 0; i < V; i++) {
            for(Edge e : graph[i]) {
                System.out.println(e.dest + " ");
            }
            System.out.println();
        }
    }
    void topoDFS(int current, boolean[] visited, Stack<Integer> st) {
        visited[current] = true;
        for(int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(!visited[e.dest]) {
                topoDFS(e.dest, visited, st);
            }
            st.push(current);
        }
    }
    void topologicalSort() {
        boolean[] visited = new boolean[V];
        Stack<Integer>st = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) topoDFS(i, visited, st);
        }
        while(!st.isEmpty()) {
            System.out.println(st.pop() + " ");
        }
    }
    void bridgeDFS(int current, boolean[] visited, int parent, int[] disc, int[] low, int time) {
        visited[current] = true;
        disc[current] = low[current] = ++time;
        for(int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(e.dest == parent) continue;
            else if(visited[e.dest]) low[current] = Math.min(low[current], disc[e.dest]);
            else {
                bridgeDFS(e.dest, visited, current, disc, low, time);
                low[current] = Math.min(low[current], low[e.dest]);
                if(disc[current] < low[e.dest]) {
                    System.out.println("Bridge: " + current + " - " + e.dest);
                }
            }
        }
    }
    void findBridges() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int time = 0;
        for(int i = 0; i < V; i++) {
            if(!visited[i]) bridgeDFS(i, visited, -1, disc, low, time);
        }
    }
    void apDFS(int current, boolean[] visited, int parent, int[] disc, int[] low, int time, int children, boolean[] ap) {
        visited[current] = true;
        disc[current] = low[current] = ++time;
        children = 0;
        for(int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(e.dest == parent) continue;
            else if(visited[e.dest]) low[current] = Math.min(low[current], disc[e.dest]);
            else {
                children++;
                apDFS(e.dest, visited, current, disc, low, time, children, ap);
                low[current] = Math.min(low[current], low[e.dest]);
                if(parent != -1 && disc[current] <= low[e.dest])  ap[current] = true;

            }
        }
        if(parent == -1 && children > 1) ap[current] = true;
    }
    void findAP() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] ap = new boolean[V];
        int time = 0;
        for(int i = 0; i < V; i++) {
            if(!visited[i]) apDFS(i, visited, -1, disc, low, time, 0, ap);
        }
        for(int i = 0; i < V; i++) {
            if(ap[i]) System.out.println("Articulation Point: " + i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        GraphLL graph = new GraphLL(V);
        graph.createGraph();
        graph.topologicalSort();
        graph.findBridges();
        graph.findAP();
    }
}
