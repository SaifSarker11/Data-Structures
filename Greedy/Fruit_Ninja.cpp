#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;

int main() {
    int t; cin >> t;
    while (t--) {
        int n; cin >> n;
        vector<ll> fallTime(n), points(n);
        for (ll &x : fallTime) cin >> x;
        for (ll &x : points) cin >> x;

        vector<pair<ll, ll>> fruits(n);
        for (int i = 0; i < n; ++i) fruits[i] = {fallTime[i], points[i]};
        sort(fruits.begin(), fruits.end());

        priority_queue< ll, 
          vector<ll>, 
          greater<ll>> 
        chosen;

        for (const auto &[deadline, point] : fruits) {
            chosen.push(point);
            if ((ll)chosen.size() > deadline) chosen.pop();
        }

        ll answer = 0;
        while (!chosen.empty()) {
            answer += chosen.top();
            chosen.pop();
        }

        cout << answer << '\n';
    }
}
