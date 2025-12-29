import java.util.Random;

class RandomGeneration {
    public static void main(String[] args) {
        Random r = new Random();
        int choice = r.nextInt(3)+1;
        if(choice == 1)
            System.out.println("read book");
        else if(choice == 2)
            System.out.println("mysql");
        // else
            // System.out.println("");
    }    
}
// 0 book
// 1 mysql