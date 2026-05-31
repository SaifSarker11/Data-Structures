#include <bits/stdc++.h>
using namespace std;
int main() {
    int t; cin >> t;
    while(t--) {
        int n, m; cin >> n >> m;
        vector<vector<int>> adj1(n + 1); //adjacency list
        vector<vector<int>> adj2(n + 1, vector<int> (n + 1, 0)); //adjacency matrix
        for(int i = 0; i < m; i++) {
            int u, v; cin >> u >> v;
            adj1[u].push_back(v); adj1[v].push_back(u); //creating a node btn u and v for adjacency list
            adj2[u][v] = adj2[v][u] = 1; //if edge exits, we'll mark that as 1 for adjacency matrix
        }
        vector<int> level(n + 1, -1); //tracks level
        int s; cin >> s; level[s] = 0;
        int choice; cin >> choice;
        if(choice == 1 || choice == 2) {
        vector<bool> visited1(n + 1, false);
        queue<int> q1; 
        visited1[s] = true; q1.push(s);
        if (choice == 1) cout << "Adjacency List BFS: ";
        else  cout << "Adjacency List BFS Levels:\n";
        while(!q1.empty()) {
            int node1 = q1.front(); q1.pop();
            cout << node1 << " ";
            for(int neighbor1 : adj1[node1]) {
                if(choice == 1) {
                if(!visited1[neighbor1]) {
                    visited1[neighbor1] = true; q1.push(neighbor1);
                }
            } else if(choice == 2) {
                if(level[neighbor1] == -1) {
                    level[neighbor1] = level[node1] + 1; q1.push(neighbor1);
                }
            }
            }
        }
    }   
        cout << "\n";
        if(choice == 2) {
            for(int i = 1; i <= n; i++) {
                cout << "Node " << i << ": Level " << level[i] << "\n";
            }
        }
        if(choice == 3 || choice == 4) {
        vector<bool> visited2(n + 1, false);
        queue<int> q2;
        visited2[s] = true; q2.push(s);
        if (choice == 3) cout << "Adjacency List BFS: ";
        else  cout << "Adjacency List BFS Levels:\n";
        while(!q2.empty()) {
            int node2 = q2.front(); q2.pop();
            cout << node2 << " ";
            for(int neighbor2 = 1; neighbor2 <= n; neighbor2++) {
                if(choice == 3) {
                if(adj2[node2][neighbor2] && !visited2[neighbor2]) {
                    visited2[neighbor2] = true; q2.push(neighbor2);
                }
            } else if(choice == 4) {
                    if(adj2[node2][neighbor2] && level[neighbor2] == -1) {
                        level[neighbor2] = level[node2] + 1; q2.push(neighbor2);
                    }
                }
            }
            }
        }
        cout << "\n";
        if(choice == 4) {
            for(int i = 1; i <= n; i++) {
                cout << "Node " << i << ": Level " << level[i] << "\n";
            }
        }
        cout << "\n";
    }
}