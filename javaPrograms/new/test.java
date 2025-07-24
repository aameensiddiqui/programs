public class test {
    public static void main(String[]args) {
        //int [] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        //int [] arr = {1, 2, 3, 1, 4, 5};
        int [] arr = {20, 10, 30};
        int k = 1;
        
        for(int i = 0; i < arr.length-k+1; i++) {
           int max = 0;
           for(int j = i; j < i+k; j++){
               if(max < arr[j]) max = arr[j];
           }
           System.out.print(max+" ");
        }
        System.out.println();
    }
}
