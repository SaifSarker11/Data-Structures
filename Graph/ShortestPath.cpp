#include <bits/stdc++.h>
using namespace std;
int main() {
    int t; cin >> t;
    while(t--) {
        int n, m; cin >> n >> m;
        vector<vector<int>> adj(n + 1, vector<int> (n + 1, 0));
        for(int i = 0; i < m; i++) {
            int u, v; cin >> u >> v;
            adj[u][v] = adj[v][u] = 1;
        }
        int s; cin >> s;
        vector<int> dist(n + 1, -1); queue<int> q;
        dist[s] = 0; q.push(s);
        while(!q.empty()) {
            int node = q.front(); q.pop();
            for(int neighbor = 1; neighbor <= n; neighbor++) {
                if(adj[node][neighbor] && dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    q.push(neighbor);
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            cout << "Node " << i << ": " << dist[i] << "\n";
        }
    }
}