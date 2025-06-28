import java.util.Random;

class QuickSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[]arr = new int[100];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = r.nextInt(100);
        }
        qsort(arr);	
         for(int i = 0 ; i < arr.length ; i++){
             System.out.print(arr[i]+" ");
         }
         // int[]arr = {10, 5, 2, 3, 33, 21, 1, 43, 23, 6};
         System.out.println();
	 /* for(int i = 0 ; i < arr.length ; i++){
             System.out.print(i+" : "+arr[i] +" | ");
         }
         */

    }

    public static int[] qsort(int[]arr){

        if(arr.length < 2) return arr;
        
            int pivot = arr[0];

            // to know how many smaller and greater elements are there
            // to know the lengths of arrays to be created 
            int lessCount = 0;
            int highCount = 0;

            for(int i = 1 ; i < arr.length ; i++){
                if(arr[i] <= pivot) lessCount++;
                else highCount++;
            }
            int[]lesser = new int[lessCount];
            int[]higher = new int[highCount];
            
            // reuse
            lessCount = 0; highCount = 0;

            // fill the arrays
            for(int i = 1 ; i < arr.length ; i++){
                if(arr[i] <= pivot) lesser[lessCount++] = arr[i];
                else higher[highCount++] = arr[i];
            }

            // recursion
            qsort(lesser);
            qsort(higher);
            
            // combine lesser[] + pivot + higher[]
            int index = 0;

            for(int i = 0 ; i < lesser.length ; i++){
                arr[index++] = lesser[i];
            }
            arr[index++] = pivot;
            for(int i = 0 ; i < higher.length ; i++){
                arr[index++] = higher[i];
            }

            // return sorted array
            return arr;
    }    
}
