#include <bits/stdc++.h>
using namespace std;
// amin siddiqui
int main(){
	const int n = 5000;
	vector<int> a(n);
	for(int& x : a) x = rand() % 100123;
	int ans = 0;
	for(int i = 0; i < n; ++i){
		for(int j = i + 1; j < n; ++j){
			ans ^= __gcd(a[i], a[j]);
		}
	}
	cout << ans << endl;
}
