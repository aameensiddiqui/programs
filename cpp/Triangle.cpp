#include <bits/stdc++.h>
using namespace std;

int minimumTotal(vector<vector<int>>& triangle) {
    int n = triangle.size();
    vector<int> dp(triangle.back());
    for (int r = n - 2; r >= 0; --r) {
		for (size_t c = 0; c < triangle[r].size(); ++c) {
			dp[c] = triangle[r][c] + min(dp[c], dp[c + 1]);
		}
    }
    return dp[0];
}
int main() {
	vector<vector<int>> triangle1 = {{2},{3,4},{6,5,7},{4,1,8,3}};
	vector<vector<int>> triangle2 = {{-1},{2,3},{1,-1,-3}};
	
	cout << minimumTotal(triangle1) << endl; // 11
	cout << minimumTotal(triangle2) << endl; // -1
	return 0;
}
	
/**
	// recursive solution 
	int dfs(int row, int col, vector<vector<int>>& triangle) {
		if (row >= (int) triangle.size()) return 0;
		return triangle[row][col] + min(dfs(row + 1, col, triangle),
										dfs(row + 1, col + 1, triangle));
	}
	int minimumTotal(vector<vector<int>>& triangle) {
		return dfs(0, 0, triangle);
	}
*/
