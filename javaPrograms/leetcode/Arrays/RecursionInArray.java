class RecursionInArray {
    public static void main(String[] args) {
        int[]arr = {2, 4, 6};
        System.out.println(add(arr, 0));
    }
    public static int add(int[]arr, int index){
        if(index == arr.length) return 0;
        else return arr[index] + add(arr, index + 1);
    }
}
