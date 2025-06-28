import java.util.Scanner;
class LunarLander{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int time = 0;          		//  s
        double fuel = 7250;         //  kg
        int fuel_rate = 0;       	//  kg/s
        double altitude = 19000;    //  m
        double velocity = 1600;     //  m/s
        double aT = 0;
        double T = 0;
        double massT = 10000;

        System.out.printf("%-10s %-10s %-10s %-10s %-10s%n", "TIME(s)", "ALTITUDE(m)", "VELOCITY(m/s)", "FUEL(kg)", "FUEL RATE(kg/s)");
        
         while(altitude >= 0 && fuel >= 0){
        	 System.out.print("enter fuel rate");
        	 fuel_rate = scan.nextInt();
        	 System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-10d%n", time, altitude, velocity, fuel, fuel_rate);
        	 time = time + 10;
        	 fuel = fuel - (fuel_rate * 10);
        	 T = 300 * 1.62 * fuel_rate;
        	 aT = T / massT;
            
            
        	 if(fuel <= 0){
        		 altitude = altitude + (velocity * 10) - (0.5 * 1.62 * 10 * 10);
        		 velocity = velocity - (1.62 * 10);
        	 } else {            	
        		 altitude = altitude + (velocity * 10) + (0.5 * (aT - 1.62) * 10 * 10);
        		 velocity = velocity + (aT - 1.62) * 10;
        	 }
            
        	 // change mass of lander with usage of fuel
        	 if(massT > 0) {        		 
        		 massT = massT - (fuel_rate * 10);
        	 } else {
        		 massT = 2000;
        	 }
            
        	 // print message
            }
            System.out.printf("Final status: TIME: %d s, ALTITUDE: %.2f m, VELOCITY: %.2f m/s, FUEL: %.2f kg%n", time, altitude, velocity, fuel);
         scan.close();
    }
}



/**
 * loop through game
 * enter fuel_rate in console
 * fuel_rate can be 0 (engine is not firing at all)
 * or 
 * it can be between 8 to 200
 * each time when you enter value for fuel, 10 sec will pass 
 * and other parameters will change accordingly
 * when will loop end????????
 *      --->    i) altitude <= 0
 *              ii) fuel <= 0
 *                  if it is below a safe threshold like (< 5 m/s) the landing is a success!
 *                  and vice versa
 * 
 * massD = 2000 (constant)
 * massF = 8000 (change-----------> massF = massF - (f * time))
 * massT = massD + massF = 10000
 * T = 300 * 1.62 * f
 * at = T / massT
 * 
 * 
 * ************altitude************
 * a = a + (v * time) + [1/2 * (at - 1.62)] * time^2
 *      if fuel is empty-------->
 *      a = a + (v * time) - (1/2 * 1.62) * time^2
 * 
 * ************velocity************
 * v = v + (at - 1.62) * time
 *      if fuel is empty-------->
 *      v = v - (1.62 * time)
 * 
 * 
 */