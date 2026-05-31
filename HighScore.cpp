#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;
void bellmanFord(int n, vector<tuple<int, int, ll>>& edges) {
    vector<ll> dist(n + 1, INF);
    dist[1] = 0;

    for(int i = 1; i <= n - 1; i++) {
        for(auto& edge : edges) {
            int u, v; ll w;
            tie(u, v, w) = edge; //tuple unpacking or destructuring
            if(dist[u] != INF && dist[u] + w < dist[v]) dist[v] = dist[u] + w;
        }
    }
    vector<ll> affected_nodes(n + 1, 0);

    for(int i = 1; i <= n; i++) {
        for(auto& edge : edges) {
            int u, v; ll w;
            tie(u, v, w) = edge;
            if(dist[u] != INF && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
             affected_nodes[v] = 1;
            }
            if(affected_nodes[u]) affected_nodes[v] = 1;
        }
    }
    if(affected_nodes[n]) cout << -1 << '\n';
    else cout << -dist[n] << '\n';
}
int main() {
    int n, m; cin >> n >> m;
    vector<tuple<int, int, ll>> edges;
    while(m--) {
        int a, b; ll x; 
        cin >> a >> b >> x;
        edges.push_back({a, b, -x});
    }
    bellmanFord(n, edges);
}