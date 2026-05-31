#include <bits/stdc++.h>
using namespace std;

vector<int> countsort(vector<int> &arr) {
    int n = arr.size(), maxVal = 0;
    for(int i = 0; i < n; i++)  maxVal = max(maxVal, arr[i]);

    vector<int> count(maxVal + 1, 0);
    for(int i = 0; i < n; i++) count[arr[i]]++;

    for(int i = 1; i <= maxVal; i++) count[i] += count[i - 1];

    vector<int> ans(n);
    for(int i = n -1; i >= 0; i--) {
        ans[count[arr[i]] - 1] = arr[i];
        count[arr[i]]--;
    }

    return ans;
}

int main() {
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int i = 0; i < n; i++) cin >> arr[i];
    
    arr = countsort(arr);
    for(int i = 0; i < n; i++) cout << arr[i] << " ";
}