class ShortenPrintln {
    // Using Java "varags"(...):
    // It can accept any number of arguments
    public static void log(Object ... args) {
        for(Object o : args) System.out.println(o);
    }
    
    public static void main(String[]args) {
        log("Hello, World!");
        log("Stack", "Overflow", 'a', 'A' + 'z');
        log(2.422);
        log(18 + 2);
        log(123 - 3);
        log(200 * 300);
        log(20 / 4);
        log(false);
        log(300 > 299);
        log("!!" + 80085 + "!!");
        log("---------------------");
        log("Stack Overflow", 7007007.29993, 81 + 9.67, 123 - 3.33, 200 * 300);
    }
}
