import java.util.AbstractList;

class FourSum {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        if (arr.length < 4)
            return Collections.emptyList();
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> ans;

            @Override
            public int size() {
                if (ans == null)
                    ans = createList(arr, target);
                return ans.size();
            }

            @Override
            public List<Integer> get(int index) {
                if (ans == null)
                    ans = createList(arr, target);
                return ans.get(index);
            }
        };
    }

    private List<List<Integer>> createList(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1])
                            left++;
                        while (left < right && arr[right] == arr[right + 1])
                            right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }

            }
        }
        return ans;
    }
}
/*
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//   List<List<Integer>> as = new ArrayList<>(); 
  
// if(nums.length<4 || nums == null )
//     return as; 

//   Arrays.sort(nums);
//   int n = nums.length;

//  for(int i=0 ; i < n-3 ; i++){
//  if(i>0 && nums[i]==nums[i+1])
//      continue;

// for(int j = i+1 ; j < n-2 ; j++){

// if(j>i+1 && nums[j]==nums[j+1])
//     continue;    
// int start =j+1 ;int end = n-1 ;
// while(start<end){
// int sum = nums[i] +nums[j] + nums[start] + nums[end] ;
// if(sum==target ){
//  as.add(Arrays.asList(nums[i], nums[j],nums[start],nums[end]));

//  while(start< end && nums[start]==nums[start+1])start++ ;
//   while(start <end && nums[end]==nums[end-1]) end-- ;
//   //piche wale startand end add ho chuke h
// start++;
// end--;
// }
// else if(sum<target)
//     start++;
// else
// end--;

// }

// }}

// return as;
//    }
// }


// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//   List<List<Integer>> result = new ArrayList<>();      
//  if (nums == null || nums.length < 4) {
//             return result;
//         }
        
//         Arrays.sort(nums);
        
//         int n = nums.length;
        
//         for (int i = 0; i < n - 3; i++) {
//             // Avoid duplicate quadruples
//             if (i > 0 && nums[i] == nums[i - 1]) continue;
            
//             for (int j = i + 1; j < n - 2; j++) {
//                 // Avoid duplicate quadruples
//                 if (j > i + 1 && nums[j] == nums[j - 1]) continue; //skip repeated element       
//            int left = j + 1;
//         int right = n - 1;                
//  while ( left < right ) {
// long sum= (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                    
//   if (sum == target) {
//   result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
//  // Avoid duplicate quadruples
//    while (left < right && nums[left] == nums[left + 1]) left++;
//      while (left < right && nums[right] == nums[right - 1]) right--;
//                         //update->
//                         left++;
//                         right--;
//                     } else if (sum < target) {
//                         left++;
//                     } else {
//                         right--;
//                     }
//                 }
//             }
//         }
        
//         return result;
//     }
// }

*/
