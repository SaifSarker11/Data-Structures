#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
vector<int> parent;
vector<int> dijsktra(int src, vector<vector<pair<int, int>>>& adj, int n) {
    vector<int> dist(n + 1, INF);
    priority_queue<
        pair<int, int>,
        vector<pair<int, int>>,
        greater<pair<int, int>>
    > pq;
    dist[src] = 0;
    pq.push({0, src});
    while(!pq.empty()) {
        int d = pq.top().first; int u = pq.top().second; pq.pop();
        if(d > dist[u]) continue;
        for(auto edge : adj[u]) {
            int v = edge.first; int w = edge.second;
            cout << "Before Relaxation: \n";
            cout << "dist[" << v << "] = "; 
            if(dist[v] == INF)  cout << "INF\n";
            else cout << dist[v] << "\n";
            if(dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w; pq.push({dist[v], v}); parent[v] = u;
            }
            cout << "After Relaxation: \n";
            cout << "dist[" << v << "] = "; 
            if(dist[v] == INF)  cout << "INF\n";
            else cout << dist[v] << "\n";
            cout << endl;
        }
    }
    return dist;
}

void printPath(int dest) {
    vector<int> path;
    int current = dest;
    while(current != -1) {
        path.push_back(current); current = parent[current];
    }
    reverse(path.begin(), path.end());
    for(int node : path) {
        cout << node << " ";
    }
    cout << endl;
}

int main() {
    int n, m; cin >> n >> m;
    vector<vector<pair<int, int>>> adj(n + 1);
    parent.resize(n + 1, -1);
    while(m--) {
        int u, v, w; cin >> u >> v >> w;
        adj[u].push_back({v, w}); adj[v].push_back({u, w});
    }
    int S, M, D; cin >> S >> M >> D;
    vector<int> fromS = dijsktra(S, adj, n);
    printPath(M);
    vector<int> fromM = dijsktra(M, adj, n);
    printPath(D);
    if(fromS[M] == INF || fromM[D] == INF) cout << -1 << endl;
    else cout << fromS[M] + fromM[D] << endl;
}
