#include <bits/stdc++.h>

using namespace std;

int gen(int a, int m) {


	set<int> seen;
	seen.insert(a);
	int curr = 1;
	int count = 1;
	if (a == 1) {
		curr = 2;
		count = 1;
	}



	int lastDiff = 1;
		
	while (seen.find(m) == seen.end()) {
		//cout << " a " << a << " curr " << curr << endl;
		a += curr;
		seen.insert(a);
		//cout << " inserting1 " << a << endl;
		set<int> diffs;
		int mini = INT_MAX;
		for (auto it : seen) {
			//if (*it == seen.end() - 1) continue;
			if (it == a) continue;
			//cout << " inserting2 " << a - it << endl;
			//seen.insert(a - it);

			mini = min(mini, a - it);
			diffs.insert(a - it);
		}	
		//for (auto it : seen) cout << it << " " ;
		//cout << "\n---------diffs" << endl;
		//for (auto it : diffs) cout << it << " "; cout << endl;

		//for (auto it : toinsert) seen.insert(it);
		/*for (int i = lastDiff + 1; seen.find(i) != seen.end() || diffs.find(i) != diffs.end(); i++) {
			curr = i;
		}*/
		curr = min(lastDiff + 1, mini);
		curr++; 	
		lastDiff = curr;
		count++;
		if (diffs.find(m) != diffs.end()) break;
	}
	return count;
	//cout << " a " << a << " m " << m << " count " << count << endl;
}

int main() {
	int a, m; cin >> a >> m;
	cout << gen(a, m) <<endl;

}
