#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;
void negativeCycleFinder(int n, vector<tuple<int, int, ll>>& edges) {
    vector<ll> dist(n + 1, 0);
    vector<int> parent(n + 1, -1);
    int x = -1;
    dist[1] = 0;
    for(int i = 1; i <= n; i++) {
        x = -1;
        for(auto& edge : edges) {
            int u, v; ll w;
            tie(u, v, w) = edge;
            if(dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
                parent[v] = u;
                x = v;
            }
        }
    }
    if(x == -1) {
        cout << "NO\n"; return;
    }
    for(int i = 1; i <= n; i++) {
        x = parent[x];
    }
    vector<int> cycle;
    int curr = x;
    do {
        cycle.push_back(curr); curr = parent[curr];
    } while(curr != x);
    cycle.push_back(x);
    reverse(cycle.begin(), cycle.end());
    cout << "YES\n";
    for(auto& node : cycle) cout << node << " ";
    cout << "\n";
}
int main() {
    int n, m; cin >> n >> m;
    vector<tuple<int, int, ll>> edges;
    while(m--) {
        int a, b; ll c; cin >> a >> b >> c;
        edges.push_back({a, b, c});
    }
    negativeCycleFinder(n, edges);
}