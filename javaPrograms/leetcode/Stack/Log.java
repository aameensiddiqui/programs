import java.util.Arrays;

public class Log {
    public void info(Object...args) {
        for(Object ob : args) {
            if(ob != null && ob.getClass().isArray()) {
                if(ob instanceof Object[])       System.out.println(Arrays.deepToString((Object[]) ob));
                else if(ob instanceof short[])   System.out.println(Arrays.toString((short[]) ob));
                else if(ob instanceof byte[])    System.out.println(Arrays.toString((byte[]) ob));
                else if(ob instanceof int[])     System.out.println(Arrays.toString((int[]) ob));
                else if(ob instanceof float[])   System.out.println(Arrays.toString((float[]) ob));
                else if(ob instanceof double[])  System.out.println(Arrays.toString((double[]) ob));
                else if(ob instanceof long[])    System.out.println(Arrays.toString((long[]) ob));
                else if(ob instanceof char[])    System.out.println(Arrays.toString((char[]) ob));
                else if(ob instanceof boolean[]) System.out.println(Arrays.toString((boolean[]) ob));
            }
            else System.out.println(ob);
        }
    }
}
// amin siddiqui
// azan siddiqui
