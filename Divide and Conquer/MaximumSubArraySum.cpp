#include <bits/stdc++.h>
using namespace std;

long long maxCrossSum(vector<long long>& arr, int left, int mid, int right) {
    long long leftSum = -1e18, sum = 0;
    for(int i = mid; i >= left; i--) {
        sum += arr[i]; leftSum = max(leftSum, sum);
    }
    
    long long rightSum = -1e18; sum = 0;
    for(int i = mid + 1; i <= right; i++) {
        sum += arr[i]; rightSum = max(rightSum, sum);
    }

    return leftSum + rightSum;
}

long long maxSubArraySum(vector<long long>& arr, int left, int right) {
    if(left > right) return -1e18;
    if(left == right) return arr[left];
    int mid = left + (right - left) / 2;
    long long leftMaxSum = maxSubArraySum(arr, left, mid);
    long long rightMaxSum = maxSubArraySum(arr, mid + 1, right);
    long long crossMaxSum = maxCrossSum(arr, left, mid, right);
    
    return max({leftMaxSum, crossMaxSum, rightMaxSum});
}

int main() {
    int n; cin >> n; vector<long long> arr(n);
    for(int i = 0; i < n; i++) cin >> arr[i];
    cout << maxSubArraySum(arr, 0, n - 1) << "\n";
}