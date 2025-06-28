class Greet {
    public static void main(String[] args) {
        greet("Priyanka");
    }   
    public static void greet(String name){
        System.out.println("Hello "+ name+"! greet()");
        greet2("Aditya");
        System.out.println("getting ready to say goodbye...");
        bye();
    } 
    public static void greet2(String name){
        System.out.println("Hello "+ name+"! greet2()");
    } 
    public static void bye(){
        System.out.println("Bye!");
    } 
}
