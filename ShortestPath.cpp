#include<bits/stdc++.h>
using namespace std;
int main() {
    int t; cin >> t;
    while(t--) {
        int n, m; cin >> n >> m;
        vector<vector<int>> adj(n + 1);
        vector<bool> vis(n + 1, false);
        vector<int> dist(n + 1, -1);
        while(m--) {
            int u, v; cin >> u >> v;
            adj[u].push_back(v); adj[v].push_back(u);
        }
        int src, dest; cin >> src >> dest;
        queue<int> q;
        vis[src] = true; dist[src] = 0, q.push(src);
        while(!q.empty()) {
            int node = q.front(); q.pop();
            for(int neighbor : adj[node]) {
                if(!vis[neighbor]) {
                    vis[neighbor] = true;
                    dist[neighbor] = dist[node] + 1; 
                    q.push(neighbor);
                }
            }
        }
        cout << dist[dest] << endl;
    }
}