/*
Given an array of N integers.
Every number in the array except one appears twice.
Find the single number in the array.

                   *
[1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]
 |  |  |  |  |  |  |  |  |  |  |
 e  o  e  o  e  o  m  o  e  o  e
 0  1  2  3  4  5  6  7  8  9  10

 left side pe even-odd, even-odd chal raha hai
 right side pe odd-even, odd-even chal raha hai

The index sequence of the duplicate numbers in the left half
is always (even, odd).
That means one of the following conditions will be satisfied
if we are in the left half:
    If the current index is even, the element at the next odd
    index will be the same as the current element.
    
    Similarly, If the current index is odd, the element at the
    preceding even index will be the same as the current element.

The index sequence of the duplicate numbers in the right half
is always (odd, even).
That means one of the following conditions will be satisfied
if we are in the right half:
    If the current index is even, the element at the preceding odd
    index will be the same as the current element.

    Similarly, If the current index is odd, the element at the next even
    index will be the same as the current element.
-------
therefore,
we can easily identify the left and right halves,
just by checking the sequence of the current index, i (mid), like the following:

If (i % 2 == 0 and arr[i] == arr[i+1]) or (i%2 == 1 and arr[i] == arr[i-1])
we are in the left half.

If (i % 2 == 0 and arr[i] == arr[i-1]) or (i%2 == 1 and arr[i] == arr[i+1])
we are in the right half.
*/
class SingleElement {

    public static int solution(int[]arr) {

        // edge cases
        if(arr.length == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[arr.length-1] != arr[arr.length-2]) return arr[arr.length-1]; 

        int low = 1;
        int high = arr.length-2;
        
        while(low <= high) {
            int mid = low + (high-low) / 2;

            if(arr[mid-1] != arr[mid] && arr[mid] != arr[mid+1])
                return arr[mid];

            // we are on the left side
            if((mid % 2 == 1 && arr[mid] == arr[mid-1]) || (mid % 2 == 0 && arr[mid] == arr[mid+1]))
                low = mid+1; // eleminate the left half
            // we are on the right side
            else high = mid-1; //eleminate the right half
        }
        return -1;
    }
    
    public static void main(String[]args) {
        int[]arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(solution(arr));
    }
}
