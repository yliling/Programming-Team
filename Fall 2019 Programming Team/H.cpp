#include <bits/stdc++.h>

using namespace std;

int countChars(string & s) {
 set<char> se;
 for (auto i : s) {
	se.insert(i);
 }

 return se.size();
}
int main() {
	int l, n; cin >> l >> n;
	int count = 0;
	for (int i = l; i <= n; i++) {
		string s = to_string(i);
		bool valid = true;
                if (countChars(s) < 6) {
			continue;
		}
		for (int j = 0; j < 6; j++) {
			//cout << s[j] - 48 << endl;
			//cout << j%(s[j] - 48) << endl;
			if (s[j] - 48 == 0) {
				valid = false;
				break;
			}
			if (i%(s[j] - 48) != 0) {
				valid = false;
				break;
				
			}
		}
		if (valid) {
			//cout << i << endl;
			count++;
		}	

	}
	cout << count << "\n";
}
