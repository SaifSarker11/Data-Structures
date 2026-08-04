#include <bits/stdc++.h>
using namespace std;

string longestNiceSubstring(const string& s) {
    if (s.length() < 2) return "";
    unordered_set<char> char_set(s.begin(), s.end());
    for (int i = 0; i < (int)s.length(); i++) {
        char c = s[i];
        if (char_set.count(tolower(c)) && char_set.count(toupper(c))) continue;

        string leftPart = longestNiceSubstring(s.substr(0, i));
        string rightPart = longestNiceSubstring(s.substr(i + 1));

        return leftPart.length() >= rightPart.length() ? leftPart : rightPart;
    }
    return s;
}

int main() {
    string s; cin >> s;
    cout << longestNiceSubstring(s) << "\n";
}