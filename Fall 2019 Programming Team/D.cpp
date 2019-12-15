#include <bits/stdc++.h>

using namespace std;

int main() {
	map<char, int> cards;
	for (int i = 0; i < 5; i++) {
		string s; cin >> s;
		cards[s[0]]++;
	}
	int maxi = INT_MIN;
	for (auto i : cards) {
		maxi = max(maxi, i.second);
	}
	cout << maxi << "\n";
}
