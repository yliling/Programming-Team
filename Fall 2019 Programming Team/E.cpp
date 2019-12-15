#include <bits/stdc++.h>

using namespace std;

map<pair<int, int>, int> seen;
int countFactors(int x, int y) {

	if (seen.find(make_pair(x, y)) != seen.end()) return seen[make_pair(x, y)];
	if (x > y) {
		int t = x;
		x = y;
		y = t;
	}
	
	if (y%x == 0) {
		seen[make_pair(x, y)] = 0;
		return 0;
	}
	for (int i = 2; i*i <= x; i++) {
		if (x%i != 0) continue;
		//cout << "checking factor " << i << endl;
		if (y%i == 0 || y%(x/i) == 0) {
			seen[make_pair(x, y)] = 0;
			return 0;
		}
	} 
	seen[make_pair(x, y)] = 1;
	return 1;
}

int main() {
	int a, b, c, d; cin >> a >> b >> c >> d;
	int count = 0;
	for (int i = a; i <= b; i++) {
					cout << "-------------------- " << i << endl;
		 int mycount = 0;
		for (int j = c; j <= d; j++) {

			if (j == 1 || i == 1) {
				//cout << i << " and " << j << " are coprime " << endl;
				seen[make_pair(i, j)] = 1;
				mycount++;
				continue;
			}
			if (i == j) continue;
			
			mycount += countFactors(i, j);
			if (countFactors(i, j)) {
				
				//cout << i << " and " << j << " are coprime " << endl;

			}
		}
		cout << "got " << mycount << endl;
	}

	//special case 1
	//if (a == 1) count += (d - c);
	//if (c == 1) count += (b - a);
	//cout << count << "\n";
}
