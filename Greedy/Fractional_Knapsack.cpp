#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll INF = 1e18;

int main() {
    ll n, W; cin >> n >> W;

    vector<pair<ll, ll>> items(n);
    for (int i = 0; i < n; i++) cin >> items[i].first >> items[i].second;

    sort(items.begin(), items.end(), [](pair<ll, ll> a, pair<ll, ll> b) {
        return (long double)a.second / a.first > (long double)b.second / b.first;
    });

    long double answer = 0;

    for (int i = 0; i < n && W > 0; i++) {
        ll weight = min(W, items[i].first);
        answer += (long double)weight * items[i].second / items[i].first;
        W -= weight;
    }

    cout << (ll)answer << '\n';
}
