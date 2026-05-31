#include <bits/stdc++.h>
using namespace std;
bool hasCycle;
void dfs(int node, int parent, vector<vector<int>> &adj, vector<bool> &visited) {
    visited[node] = true;
    for(int neighbor : adj[node]) {
        if(!visited[neighbor]) dfs(neighbor, node, adj, visited);
        else if(neighbor != parent) hasCycle = true;
    }
}
int main() {
    int t; cin >> t;
    while(t--) {
        int n, m; cin >> n >> m;
        vector<vector<int>> adj(n + 1); vector<bool> visited(n + 1, false);
        while(m--) {
            int u, v; cin >> u >> v;
            adj[u].push_back(v); adj[v].push_back(u);
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                hasCycle = false; dfs(i, -1, adj, visited);
                if(hasCycle) ans++;
            }
        }
        cout << ans << "\n";
    }
}