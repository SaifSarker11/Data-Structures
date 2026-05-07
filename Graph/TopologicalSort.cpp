#include <bits/stdc++.h>
using namespace std;
bool dfs(int node, vector<vector<int>>& adj, vector<int>& state, stack<int>& st) {
    state[node] = 1;
    for(int neighbor : adj[node]) {
        if(state[neighbor] == 1) return false;
        if(state[neighbor] == 0) 
            if(!dfs(neighbor, adj, state, st)) return false;
    }
    state[node] = 2;
    st.push(node);
    return true;
}
int main() {
    int t; cin >> t;
    while(t--) {
        int n, m; cin >> n >> m;
        vector<vector<int>> adj(n + 1);
        vector<int> state(n + 1, 0);
        stack<int> st;
        while(m--) {
            int u, v; cin >> u >> v;
            adj[u].push_back(v);
        }
        for(int i = 1; i <= n; i++)
            sort(adj[i].begin(), adj[i].end());
        bool hasCycle = false;
        for(int i = 1; i <=n && !hasCycle; i++) {
            if(state[i] == 0)
                if(!dfs(i, adj, state, st)) hasCycle = true;
        }
        if(hasCycle) cout << -1 << "\n";
        else {
            while(!st.empty()) {
                cout << st.top() << " "; st.pop();
                cout << (st.empty() ? "\n" : " ");
            }
        }
    } 
}