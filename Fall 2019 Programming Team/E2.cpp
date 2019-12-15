#include <bits/stdc++.h>

using namespace std;

map<pair<int, int>, int> seen;
int firstPrime = -1;
int numCoprime = 0;
bool isPrime(int x) {
	for (int i = 2; i*i <= x; i++) {
		if (x%i == 0) return false;	
	}
	return true;
}

int countFactors(int x, int y) {
	if (x == 1 || y == 1) return 1;
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

vector<int> gen(int x, int c, int d) {
	vector<int> nums(0);
	int sum = x;
	int prev = -1;

	for (int i = c; i <= d && sum > 0; i++) {
		if (countFactors(x, i)) {
			if (firstPrime == -1) firstPrime = i;
			numCoprime++;
			//cout << " found " << x  << " " << i << endl;
			if (prev == -1) prev = i;
			else {
				nums.push_back(i - prev);
				sum -= i - prev;
				prev = i;
			}

			
			
		}
	}
	if (numCoprime == 1) nums.push_back(prev); 
	return nums;
}

int countNums(int x, vector<int> nums, int c, int d) {
	int count = 0;
	int j = 0;
	for (int sum = firstPrime; sum <= d; ) {
		if (x%sum != 0 && c <= sum && d >= sum) count++;
		//cout << "nums " << nums[j] << endl;
		//cout << " sum " << sum << endl;
		sum += nums[j];
		j++; 
		j %= nums.size();
	}
	return count;
}
int main() {
	int a, b, c, d; cin >> a >> b >> c >> d;
	int count = 0;
	for (int i = a; i <= b; i++) {
		//cout << "-------------------- " << i << endl;
		//for (int j = c; j <= d; j++) {
			if (i == 1) {
				//cout << i << " and " << j << " are coprime " << endl;
				//seen[make_pair(i, j)] = 1;
				//cout << " is 1 goes up by " << d - c + 1 << endl;
				count += (d - c + 1);
				//cout << "got " << d -c + 1 << endl;
				continue;
			}
			//if (i == j) continue;
			
			if (isPrime(i)) {
				//int n = (d - c)/i;
				/*if (c == d) {
					count += countFactors(i, c);
					continue;
				}*/
				
				int k = c;
				while(k%i != 0) k++;
				if (k > d) {
					//cout << "got " << d - c + 1 << endl;
					count += d - c + 1;
					continue;				
				}
				//printf(" k becomes %d\n", k);
				int n = (d -k)/i;
				int inc = (i - 1)*n + (d - k)%i + k - c;
				//if (c == 1) inc -= i - 1;
				//cout << "got " << inc << endl;
				count += inc;
				//cout << " count is now " << count << endl;
				continue;
			}
			//cout << " checking " << i;
			vector<int> nums = gen(i, c, d);
			//cout << " -- nums ";
			//for (auto i : nums) cout << i << " ";

			//cout << endl;
			//cout << countNums(i, nums, c, d) << endl;
			//count += countNums(i, nums, c, d);
			if (nums.size() == 1 && numCoprime == 1) {
				//cout << "got2 " << countFactors(i, nums[0]) << endl;
				count += countFactors(i, nums[0]);
			}
			else if(nums.size() != 0) {
				int numBlocks = ((d - firstPrime + 1)/i);
				//cout << "numBLOCKS " << numBlocks << endl;
				int k = numBlocks*i + firstPrime;
				int j = 0;
				int runningSum = 0;
				while (k + runningSum <= d) {
					//cout << " running sum " << runningSum << endl;
					//cout << " k + rs " << k + runningSum << endl;
				        //cout << " j " << j << " \n";
					//cout << nums[j] << endl;
					runningSum += nums[j];
					j++;

				}

				int totalNums = numBlocks*(nums.size());	
				if (d == i && numBlocks == 1) totalNums++;
				//cout << " first " << j << " numbers in last block " << endl; 
				//if (c == 1) count++;
				int inc = totalNums + j;
				//if (numBlocks*nums.size() == d) inc++;
				//if (numBlocks*nums.size() == totalNums + j) inc++;
				count += inc;
				//cout << "got " << inc << endl;
				numCoprime = 0;
				firstPrime = -1;
				/*count += countFactors(i, j);
				if (countFactors(i, j)) {
					cout << i << " and " << j << " are coprime " << endl;
					count++;
				}*/
			}
		//}                                                                                               
	}

	//special case 1
	//if (a == 1) count += (d - c);
	//if (c == 1) count += (b - a);
	cout << count << "\n";
}
