#include <bits/stdc++.h>
using namespace std;

void bubble_sort(vector<int> &arr) {
    int n = arr.size();
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < n - i - 1; j++) {
            if(arr[j] > arr[j + 1]) swap(arr[j], arr[j + 1]);
        }
    }
}

void selection_sort(vector<int> &arr) {
    int n = arr.size();
    for(int i = 0; i < n - 1; i++) {
        int smallest = i;
        for(int j = i + 1; j < n; j++) {
            if(arr[smallest] > arr[j]) smallest = j;
        }
        swap(arr[smallest], arr[i]);
    }
}

void insertion_sort(vector<int> &arr) {
    int n = arr.size();
    for(int i = 1; i < n; i++) {
        int prev = i - 1;
        int current = arr[i];
        while(prev >= 0 && arr[prev] > current) {
            arr[prev + 1] = arr[prev];
            prev--;
        }
        arr[prev + 1] = current;
    } 
}

void print_array(vector<int> &arr) {
    for(int i = 0; i < arr.size(); i++) {
        if(i != arr.size() - 1) cout << arr[i] << ", ";
        else cout << arr[i] << ". ";
    }
}

int main() {
    int n;
    cin >> n;
    vector<int> arr(n);

    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    
    int choice;
    cin >> choice;
    switch(choice) {
        case 1:
            bubble_sort(arr);
            print_array(arr);
            break;
        case 2:
            selection_sort(arr);
            print_array(arr);
            break;
        case 3:
            insertion_sort(arr);
            print_array(arr);
            break;
        default:
            cout << "Invalid choice!" << endl;
    }
}