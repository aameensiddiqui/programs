import java.util.Scanner;

public class LunarLanderX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double altitude = 500.0;  // Initial altitude in feet
        double velocity = 50.0;   // Initial velocity in feet per second
        double fuel = 120.0;      // Initial fuel units
        double gravity = 5.0;     // Gravity effect per turn
        double thrustFactor = 0.3; // Fuel efficiency factor
        int time = 0;

        System.out.println("Welcome to LUNAR LANDER (1969) by Jim Storer");
        System.out.println("You must safely land your module on the Moon.");

        while (altitude > 0) {
            System.out.println("Time: " + time + " seconds");
            System.out.printf("Altitude: %.2f feet, Velocity: %.2f ft/sec, Fuel: %.2f units%n", altitude, velocity, fuel);
            
            System.out.print("Enter fuel to burn (0-30): ");
            double burn = scanner.nextDouble();
            
            if (burn < 0) burn = 0;
            if (burn > 30) burn = 30;
            if (burn > fuel) burn = fuel;  // Limit burn to available fuel
            
            fuel -= burn;
            double acceleration = gravity - (burn * thrustFactor);
            velocity += acceleration;
            altitude -= velocity;
            time++;
        }

        System.out.printf("Landed at %.2f ft/sec. ", velocity);
        if (velocity > 5.0) {
            System.out.println("Crash! You didn't survive.");
        } else {
            System.out.println("Safe landing! Congratulations!");
        }

        scanner.close();
    }
}
