#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> vals;

int check(int a, int b, int c) {
	//check a to b
	int ab = abs(vals[b].size() - vals[a].size());
	int bc = abs(vals[b].size() - vals[c].size());
	if (ab > 1 || bc > 1) return -1;
	
	int astart = vals[a][0], bstart = vals[b][0], cstart = vals[c][0];

	int start = min(astart, min(bstart, cstart));

	int n = -1;
	int j = 0;
	if (bstart == start) j = 1;		
	for (int i = 0; i < vals[a].size(); i++) {
		if (j == b.size()) {
			//make sure last a is within the end
		}
	}

	int m = -1;
	for (int i = bstart; i < vals[b].size(); i++) {
		for (int j = (cstart == start) ? 1 : 0; j < vals[c].size(); j++) {
			if (m == -1) m = vals[c][j] - vals[b][i];
			else if (m != vals[c][j] - vals[b][i]) return -1;
		}		
	}
	
}
int gen() {
	for (int i = 0; i <= 9; i++) {
		for (int j = 0; j <= 9; j++) {
			for (int k = 0; k <= 9; k++) {
				check(i, j, k);
			}
		}
	}

}
int main() {
	int p; cin >> p
	int i = 0;
	while (p--) {
		int a; cin >> a;
		vals[a].push_back(i);	
		i++;
	}
	
	
}
