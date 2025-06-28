/*
 * made a sorting algorith while trying to make bubble sort
 * this algorithm is a sort of like selection sort but worse because it makes more swaps than selection sort
 * as it compares each element to the right, and if smaller one is found,
 * it makes a swap
 */
class AminSort {
    public static void main(String[]args){
        int[]arr = {13,46,24,52,20,9,32,22,1};

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }    
}
