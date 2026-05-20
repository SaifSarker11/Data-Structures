#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;
void dijsktra(ll n, vector<vector<pair<ll, pair<ll, ll>>>>& adj) {
    vector<ll> distance(n + 1, INF); vector<ll> toll(n + 1, INF);
    // {{distance, toll_cost}, node}
    priority_queue<
        pair<pair<ll, ll>, ll>,
        vector<pair<pair<ll, ll>, ll>>,
        greater<pair<pair<ll, ll>, ll>>
    > pq;
    distance[1] = 0; toll[1] = 0; pq.push({{0, 0}, 1});
    while(!pq.empty()) {
        ll d = pq.top().first.first; ll c = pq.top().first.second; ll u = pq.top().second; pq.pop();
        if(d > distance[u] || (d == distance[u] && c > toll[u])) continue;
        for(auto& edge : adj[u]) {
            ll v = edge.first; ll time = edge.second.first; ll cost = edge.second.second;
            ll newDist = d + time; ll newCost = c + cost;
            if(newDist < distance[v]) {
                distance[v] = newDist; toll[v] = newCost;
                pq.push({{newDist, newCost}, v});
            }
            else if(newDist == distance[v] && newCost < toll[v]) {
                toll[v] = newCost; 
                pq.push({{newDist, newCost}, v});
            }
        }
    }
    if(toll[n] == INF) cout << -1 << '\n';
    else cout << toll[n] << '\n';
}
int main() {
    ll t; cin >> t;
    while(t--) {
        ll n, m; cin >> n >> m;
        vector<vector<pair<ll, pair<ll, ll>>>> adj(n + 1);
        while(m--) {
            ll u, v, t, c; cin >> u >> v >> t >> c;
            adj[u].push_back({v, {t, c}}); adj[v].push_back({u, {t, c}});
        }
        dijsktra(n, adj);
    }
}