class P {
    public static void main(String[] args) {
        int[]arr = {22, 11, 55, 44, 77, 88};
        for (int i : arr) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i+" ");
        }
    }    
}
