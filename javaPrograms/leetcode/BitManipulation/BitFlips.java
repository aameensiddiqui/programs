class BitFlips {
    public static int minBitFlips(int start, int goal) {
        int n = start ^ goal;
        int cnt = 0;
        while(n != 0) {
            n = n & n-1;
            cnt++;
        }
        return cnt;
    }
    public static void main(String[]args) {
        log.info(minBitFlips(10, 7));
    }
    private static final Log log = new Log();
}
