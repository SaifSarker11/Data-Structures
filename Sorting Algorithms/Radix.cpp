#include <bits/stdc++.h>
using namespace std;

int getMax(vector<int> &arr) {
    int maxVal = 0, n = arr.size();
    for(int i = 0; i < n; i++) maxVal = max(maxVal, arr[i]);
    return maxVal;
}

void countsort(vector<int> &arr, int exp) {
    int n = arr.size();
    vector<int> count(10, 0);
    for(int i = 0; i < n; i++) count[(arr[i] /exp) % 10]++;

    for(int i = 1; i < 10; i++) count[i] += count[i - 1];

    vector<int> output(n);
    for(int i = n - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }
    
    for(int i = 0; i < n; i++) arr[i] = output[i];
}

void radixsort(vector<int> &arr) {
    int maxValue = getMax(arr);
    for(int exp = 1; maxValue / exp > 0; exp *= 10) {
        countsort(arr, exp);
        cout << "Sorted by " << exp << " 's place: ";
        for(int x : arr) cout << x << " ";
        cout << endl;
    }
}

int main() {
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int i = 0; i < n; i++) cin >> arr[i];
    radixsort(arr);
}