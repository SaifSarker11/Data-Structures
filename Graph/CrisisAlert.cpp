#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;
void BellmanFord(int n, vector<tuple<int,int,long long>> &edges, vector<long long> &dist) {
    for(int i = 1; i <= n - 1; i++) {
        for(auto [u,v,w] : edges) {
            if(dist[u] == INF) continue;
            if(dist[u] + w < dist[v]) dist[v] = dist[u] + w;
        }
    }
}

int main() {
    int n, m, k; cin >> n >> m >> k;
    vector<tuple<int,int,long long>> edges;
    while(m--) {
        int u, v; ll w; cin >> u >> v >> w;
        edges.push_back({u, v, w});
    }
    vector<ll> dist(n + 1, INF);
    for(int i = 1; i <= k; i++) {
        int tower; cin >> tower;
        dist[tower] = 0;
    }
    BellmanFord(n, edges, dist);
    for(int i = 1; i <= n; i++) {
        if(dist[i] == INF) cout << "INF\n";
        else cout << dist[i] << '\n';
    }
}