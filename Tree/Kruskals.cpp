#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int find_set(int v, vector<int>& parent) {
    if(v == parent[v]) return v;
    return parent[v] = find_set(parent[v], parent);
}
bool unite_set(int u, int v, vector<int>& parent) {
    int root_u = find_set(u, parent); int root_v = find_set(v, parent);
    if(root_u != root_v) {
        parent[root_v] = root_u; return true;
    }
    return false;
}
int mstKruskals(int n, vector<pair<ll, pair<int, int>>>& edges) {
    sort(edges.begin(), edges.end());
    vector<int> parent(n + 1);
    for(int i = 0; i <= n; i++) parent[i] = i;
    int edges_count = 0; ll mstWeightCost = 0;
    for(int i = 0; i < edges.size(); i++) {
        ll w = edges[i].first;
        int u = edges[i].second.first;
        int v = edges[i].second.second;
        if(unite_set(u, v, parent)) {
            mstWeightCost += w; edges_count++;
        }
    }
    if(edges_count == n - 1) return mstWeightCost;
    else return -1;
}
int main() {
    int t; cin >> t;
    while(t--) {
        int n, m; cin >> n >> m;
        vector<pair<ll, pair<int, int>>> edges(m);
        for(int i = 0; i < m; i++) {
            int u, v; ll w; cin >> u >> v >> w;
            edges[i] = {w, {u, v}};
        }
        cout << mstKruskals(n, edges) << "\n";
    }
}