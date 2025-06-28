class Recursion {

    /*
     * rPrint function for recursion
     */

    public static void rPrint(int n){
        if(n <= 0){
            return;
        }
        else {
            rPrint(n-1);
        }
    }
    public static void main(String[] args) {
        double totalNanosForRecur = 0;
        double totalNanosForWhile = 0;
        
        /*
         * checking recursion
         */

        for(int i = 0 ; i < 1000000 ; i++){
            int n1 = 1000;
            long start = System.nanoTime();
            rPrint(n1);
            long end = System.nanoTime();
            totalNanosForRecur += (end - start);
        }
        double avgNanoSecsForRecur = totalNanosForRecur / 1000000;
        System.out.println("Average time for recursion: " + avgNanoSecsForRecur + " nano secs");
         
        /*
         * checking while loop
         */

        for(int i = 0 ; i < 1000000 ; i++){
            int n2 = 1000;
            long start = System.nanoTime();
            while(n2 >= 0){
                n2--;
            }
            long end = System.nanoTime();
            totalNanosForWhile += (end - start);
        }
        double avgNanoSecsForWhile = totalNanosForWhile / 1000000;
        System.out.println("Average time for whileloop: " + avgNanoSecsForWhile + " nano secs");

        /*
         * printing results
         */

        System.out.println("difference => " + (avgNanoSecsForRecur - avgNanoSecsForWhile) + " nano secs");
        if(totalNanosForRecur > totalNanosForWhile) System.out.println("while loop won");
        else System.out.println("recursion won");
    }
}
