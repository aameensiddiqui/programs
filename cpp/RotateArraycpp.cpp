#include <bits/stdc++.h>
using namespace std;

int main() {
  vector<int>nums = {1,2,3,4,5,6,7};
  int k = 3;
  
  //--------------------------------
  int n = nums.size();
  k = k % n;
  int l = n - k;

  for (int i = 0; i < l/2; i++)
    swap(nums[i] , nums[l-i-1]);

  for (int i = l; i < (l) + k/2; i++)
    swap(nums[i] , nums[n-i+(l)-1]);

  for(int i = 0 ; i < ((n+1)/2); i++)
    swap(nums[i] , nums[n-i-1]);
  //-----------------------------------

  for(int i = 0; i < nums.size(); ++i)
    cout << nums[i] << " ";
  cout << endl;

}
