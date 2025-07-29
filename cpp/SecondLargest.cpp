#include <bits/stdc++.h>
using namespace std;
    
int main() {
	//vector<int>nums = {10, 10, 10, 10, 10};
	vector<int>nums = {8, 8, 7, 6, 5};
	if(nums.size() < 2) {
		cout << -1 << endl;
		return 0;
	}
	int large = INT_MIN;
	int second_large = INT_MIN;

	for(size_t i = 0; i < nums.size(); ++i) {
		if(nums[i] > large) {
			second_large = large;
			large = nums[i];
		}
		if(nums[i] < large && nums[i] > second_large)
			second_large = nums[i];
	}
	if(second_large == INT_MIN) cout << -1 << endl;
	else cout << second_large << endl;
	return 0;
}
