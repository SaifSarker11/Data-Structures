#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;
void floydWarshall(vector<vector<ll>>& distanceMatrix, int n) {
    for(int k = 0; k < n; k++) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(distanceMatrix[i][k] == INF || distanceMatrix[k][j] == INF) continue;
                distanceMatrix[i][j] = min(distanceMatrix[i][j], distanceMatrix[i][k] + distanceMatrix[k][j]);
            }
        }
    }
}
int main() {
    int t; cin >> t;
    while(t--) {
        int n, m; cin >> n >> m;
        vector<vector<ll>> distanceMatrix(n, vector<ll>(n, INF));
        for(int i = 0; i < n; i++) distanceMatrix[i][i] = 0;
        for(int i = 0; i < m; i++) {
            int u, v; ll w; cin >> u >> v >> w;
            distanceMatrix[u][v] = min(distanceMatrix[u][v], w);
        }
        floydWarshall(distanceMatrix, n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(distanceMatrix[i][j] == INF) cout << "INF ";
                else cout << distanceMatrix[i][j] << " ";
            }
            cout << "\n";
        }
    }
}