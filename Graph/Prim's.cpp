#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll mstViaPrims(vector<vector<pair<int, int>>>& adjList, int n) {
    priority_queue <
        pair<int, int>,
        vector<pair<int, int>>,
        greater<pair<int, int>>
    > pq;
    vector<bool> visited(n, false);
    ll mstCost = 0;
    pq.push({0, 0});
    while(!pq.empty()) {
        int currentEdgeWeight = pq.top().first;
        int currentVertex = pq.top().second;
        pq.pop();
        if(!visited[currentVertex]) {
            visited[currentVertex] = true; 
            mstCost += currentEdgeWeight;
            for(auto neighbor : adjList[currentVertex]) {
                int nextVertex = neighbor.first;
                int nextEdgeWeight = neighbor.second;
                if(!visited[nextVertex]) pq.push({nextEdgeWeight, nextVertex});
            }
        }
    }
    return mstCost;
}
int main() {
    int t; cin >> t;
    while(t--) {
        int n, m; cin >> n >> m;
        vector<vector<pair<int, int>>> adjList(n);
        while(m--) {
            int u, v; ll w; cin >> u >> v >> w;
            adjList[u].push_back({v, w});
            adjList[v].push_back({u, w});
        }
        cout << mstViaPrims(adjList, n) << " ";
    }
}