#include <bits/stdc++.h>
using namespace std;

string largestMagical(string binString) {
    if (binString.empty()) return "";

    vector<string> ans;
    int cnt = 0, start = 0;

    // Split binString into "good substrings"
    for (int i = 0; i < binString.size(); i++) {
        if (binString[i] == '1') cnt++;
        else cnt--;

        if (cnt == 0) {
            // recursively solve inside
            string inner = binString.substr(start + 1, i - start - 1);
            ans.push_back("1" + largestMagical(inner) + "0");
            start = i + 1;
        }
    }

    // Sort substrings in descending order to maximize binary value
    sort(ans.begin(), ans.end(), greater<string>());

    // Concatenate result
    string res = "";
    for (auto &s : ans) res += s;

    return res;
}

int main() {
    string binString;
    cin >> binString;
    cout << largestMagical(binString) << endl;
    return 0;
}