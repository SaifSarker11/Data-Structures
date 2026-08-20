#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;

int main() {
    int n; cin >> n;
    vector<pair<ll, ll>> jobs(n);
    for (int i = 0; i < n; i++) cin >> jobs[i].first >> jobs[i].second;

    sort(jobs.begin(), jobs.end());

    priority_queue< ll, 
      vector<ll>, 
      greater<ll>> 
    available;

    int answer = 0;

    for (int i = 0; i < n; i++) {
        ll start = jobs[i].first; ll finish = jobs[i].second;
        while (!available.empty() && available.top() <= start) available.pop();
        available.push(finish);
        answer = max(answer, (int)available.size());
    }

    cout << answer << '\n';
}
