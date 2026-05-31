/*  ┌───┐   
    ↓   │         1 → 2 (1)           Bellman-Ford tells us: These nodes (3) are touching a negative cycle.
1 → 2 → 3         2 → 3 (-5)          BFS tells us: Starting from those nodes (3), who else (4, 5) can be reached?
        |         3 → 2 (1) 
        ↓         3 → 4 (2)           dist[2] + (-5) < dist[3]. Therefore, Node 3 is affected by a negative cycle. negative[3] = 1; push 3 into queue;
        4 → 5     4 → 5 (2)           2 ↔ 3 Infinity times. Then, 3 → 4. Hence, dist[4] = -INF & 2 ↔ 3 Infinity times. Afterwards, 3 → 5. Hence, dist[5] = -INF
                                      pop 3, 3 → 4, mark negative[4] = 1; push 4 into queue & pop 4, 4 → 5, mark negative[5] = 1; push 5 into queue
*/

#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;
void BellmanFord(int n, int src, vector<tuple<int, int, ll>>& edges, vector<ll>& dist) {
    dist[src] = 0; //distance from src to src is Zero
    //relaxation (n - 1) times
    for(int i = 1; i <= n - 1; i++) {
        for(auto& edge : edges) {
            int u, v; ll w;
            tie(u, v, w) = edge; //tuple unpacking or destructuring
            if(dist[u] == INF) continue;
            if(dist[u] + w < dist[v]) dist[v] = dist[u] + w; 
        }
    }
}
void NegativeCycleFinder(vector<tuple<int, int, ll>>& edges, vector<vector<int>>& adj, vector<ll>& dist, vector<bool>& negative) {
    queue<int>q;
    for(auto& edge : edges) { //if the distance values keep decreasing forever and if there are no real shortest paths, we scan through all edges once again and mark the nodes affected by a negative cycle via BFS
        int u, v; ll w;
        tie(u, v, w) = edge;
        if(dist[u] == INF) continue;
        if(dist[u] + w < dist[v]) { //BellmanFord already used n - 1 relaxations. Therefore, an improvement should not be possible anymore. Hence, negative cycle detected
            if(!negative[v]) {
                negative[v] = 1; q.push(v);
            }
        }
    }
    while(!q.empty()) {
        int u = q.front(); q.pop();
        for(auto& v : adj[u]) { //BFS Traversal
            if(!negative[v]) {
                negative[v] = 1; q.push(v);
            }
        }
    }
}
void printResults(int n, vector<ll>& dist, vector<bool>& negative) {
    for(int i = 1; i <= n; i++) {
        if(negative[i]) cout << "-INF\n";
        else if(dist[i] == INF) cout << "INF\n";
        else cout << dist[i] << "\n";
    }
}
int main() {
    int n, m, s; cin >> n >> m >> s;
    vector<tuple<int, int, ll>> edges;
    vector<vector<int>> adj(n + 1);
    while(m--) {
        int a, b; ll c; cin >> a >> b >> c;
        edges.push_back({a, b, c});
        adj[a].push_back(b);
    }
    vector<ll> dist(n + 1, INF);
    BellmanFord(n, s, edges, dist);
    vector<bool> negative(n + 1, false);
    NegativeCycleFinder(edges, adj, dist, negative);
    printResults(n, dist, negative);
}
