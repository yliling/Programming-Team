#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int main() {
	int n; cin >> n;
	double f = 1;
	int m = 0;
	long double s = 0;
	for (int i = 0; i <= n; i++) {
	 	s += (1.0)/f;
		m++;
		f *= m;
		//printf("s %f\n", s);
	}
	cout << setprecision(18) << s << endl;
}
