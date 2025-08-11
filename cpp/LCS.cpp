#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> &arr) {
	if(arr.size() == 0) return 0;
	unordered_set<int> s;
	for(int i = 0; i < arr.size(); ++i) {
		s.insert(arr[i]);
	}
	int cnt = 0, lcs = 1;
	for(auto i : s) {
		int x = i;
		cnt = 1;
		while(s.find(x+1) != s.end()) {
			x += 1; cnt += 1;
		}
		lcs = max(lcs, cnt);
	}
	return lcs;
	/*
	sort(arr.begin(), arr.end());
	int lastSmaller = INT_MIN;
	int cnt = 0;
	int longestSequence = 0;
	for(int i = 0; i < arr.size(); ++i) {
		if(arr[i] - 1 == lastSmaller) {
			cnt += 1;
			lastSmaller = arr[i];
		} else if(arr[i] != lastSmaller) {
			cnt = 1;
			lastSmaller = arr[i];
		}
		longestSequence = max(longestSequence, cnt);
	} 
	return longestSequence;
	*/
}

int main() {
	vector<int>arr = {100,4,200,1,3,2};
	cout << solution(arr);
	return 0;
}
