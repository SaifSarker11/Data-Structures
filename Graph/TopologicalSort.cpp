#include <bits/stdc++.h>
using namespace std;
void dfs(int node, vector<vector<int>>& adj, vector<bool>& visited, stack<int>& st) {
    visited[node] = true;
    for(int neighbor : adj[node]) {
        if(!visited[neighbor]) dfs(neighbor, adj, visited, st);
    }
    st.push(node);
}
int main() {
    int t; cin >> t;
    while(t--) {
        int n, m; cin >> n >> m;
        vector<vector<int>> adj(n + 1);
        vector<bool> visited(n + 1, false);
        stack<int> st;
        for(int i = 0; i < m; i++) {
            int u, v; cin >> u >> v;
            adj[u].push_back(v);
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) dfs(i, adj, visited, st);
        }
        while(!st.empty()) {
            cout << st.top() << " ";
            st.pop();
        }
    }
}