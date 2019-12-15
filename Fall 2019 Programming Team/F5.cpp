#include <bits/stdc++.h>

using namespace std;
vector<vector<long double>> arr(200001);

int main() {
	/*int n; cin >> n;
	int i = 0;
	int c= 0;
	
	while (c < n) {
		long double x, z; cin >> x >> z;
		arr[i].push_back(x);
		arr[i].push_back(z);	
		i++;
		c++;
	}*/

	double a = 0.2;
	double b = 1.4;
	double x = a;
	double y = b;
	int n = 200000;
	//double[] arr = new double[200000];
	for(int i = 0; i < 200000; i++){
		arr[i].push_back(x);
		arr[i].push_back(y);
		x += a;
		y += b;
	}
	
	double constant = 0;
	
	for(int i = 0; i < n; i++){

		for(int j = i + 1; j < n; j++){
			/*double left = abs(arr[i][1] - arr[j][1]);
			double diff = abs(arr[i][0] - arr[j][0]);
			double l = left/diff;

			if(l > constant){
				constant = l;
			}*/
			
		}
	}

	cout << setprecision(6) << constant << endl;

}



