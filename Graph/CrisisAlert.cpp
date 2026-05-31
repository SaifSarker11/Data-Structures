#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;
void BellmanFord(int n, vector<tuple<int, int, ll>>& edges, vector<ll>& dist) {
    //relaxation n - 1 times
    for(int i = 1; i <= n - 1; i++) { //n iterations
        for(auto& edge : edges) {
            int u, v; ll w;
            tie(u, v, w) = edge; //tuple unpacking or destructuring
            if(dist[u] == INF) continue;
            if(dist[u] + w < dist[v]) dist[v] = dist[u] + w; 
        }
    }
}
void printResults(int n, vector<ll>& dist) {
    for(int i = 1; i <= n; i++) {
        if(dist[i] == INF) cout << "INF\n";
        else cout << dist[i] << "\n";
    }
}
int main() {
    int n, m, k; cin >> n >> m >> k;
    vector<tuple<int, int, ll>> edges;
    while(m--) {
        int a, b; ll c; cin >> a >>  b >> c;
        edges.push_back({a, b, c});
    }
    vector<ll> dist(n + 1, INF);
    while(k--) {
        int tower; cin >> tower;
        dist[tower] = 0;
    }
    BellmanFord(n, edges, dist);
    printResults(n, dist);
}