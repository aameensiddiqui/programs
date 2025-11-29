import java.util.Scanner;
import java.util.Random;

class Main {

    private static Scanner scan = new Scanner(System.in);
    private static Log log = new Log();
    private static Random r = new Random();

    static int bheemHealth = 15;
    static int dragonHealth = 20;
    static int swordDamage = 4;
    static int fireBreathDamage = 6;
    static boolean hasSword = false;
    static boolean didKillDragon = false;
    static int choose;
    
    public static void main(String[]args) {
        do {
            log.info("****************************************************************************\n"+
                 "  _____ _    _ _    _  ____ _______       ____  _    _ ______ ______ __  __ \n"+
                 " / ____| |  | | |  | |/ __ \\__   __|/\\   |  _ \\| |  | |  ____|  ____|  \\/  |\n"+
                 "| |    | |__| | |__| | |  | | | |  /  \\  | |_) | |__| | |__  | |__  | \\  / |\n"+
                 "| |    |  __  |  __  | |  | | | | / /\\ \\ |  _ <|  __  |  __| |  __| | |\\/| |\n"+
                 "| |____| |  | | |  | | |__| | | |/ ____ \\| |_) | |  | | |____| |____| |  | |\n"+
                 " \\_____|_|  |_|_|  |_|\\____/  |_/_/    \\_\\____/|_|  |_|______|______|_|  |_|\n"+
                 "                                                                            \n"+
                 "****************************************************************************");
            log.info("1. NEW GAME");
            log.info("2. EXIT");
            System.out.print("Enter your choice : ");
            choose = scan.nextInt();
            log.info("***************************************************");
            switch(choose) {
            case 1:
                game();
                break;
            case 2:
                log.info("Exited...");
                choose = 0;
                log.info("***************************************************");
                choose = 0;
                break;
            }
        } while(choose != 0);
    } // end of main

    public static void game() {
        do {
            System.out.println();
            log.info("GATE********************************************");
            log.info("You are standing in front of Dholakpur.");
            log.info("There is a Soldier at the gate.");
            log.info("There are three roads behind you.");
            log.info("which go north, south and east.");
            log.info("What do you want to do?");
            log.info("1. Ask the Soldier to enter Dholakpur");
            log.info("2. Go North");
            log.info("3. Go South");
            log.info("4. Go East");
            log.info("5. View status");
            log.info("6. Exit Game");
            System.out.print("Enter your choice : ");
            choose = scan.nextInt();
            switch(choose) {
            case 1:
                ask();
                break;
            
            case 2:
                goNorth();
                break;
                
            case 3:
                goSouth();
                break;
                
            case 4:
                goEast();
                break;
                
            case 5:
                viewStatus();
                break;

            case 6:
                log.info("Exited...");
                choose = 0;
                log.info("***************************************************");
                break;
            } // end of switch
        } // end of do
        while(choose != 0);
    } // end of game()

    public static void ask() {
        System.out.println();
        log.info("ASKING******************************************");
        if(!didKillDragon) {
            log.info("STOP RIGHT THERE!!! You cannot enter Dholakpur.");
            log.info("******************************************ASKING");
            game();
        }
        else gameOver();
    }
    
    public static void goNorth() {
        System.out.println();
        log.info("NORTH*******************************************");
        log.info("There is a Firebreathing Dragon sleeping.");
        log.info("What do you want to do?");
        log.info("1. Fight the dragon.");
        log.info("2. Leave.");
        System.out.print("Enter your choice : ");
        int choose = scan.nextInt();
        switch(choose) {
        case 1:   
            fight();
            break;
        case 2:
            log.info("*******************************************NORTH");
            game();
            break;
        } // end of switch
    } // end of goNorth
    
    public static void goSouth() {
        System.out.println();
        log.info("SOUTH*******************************************");
        log.info("There is a bucket of laddoos on a table.");
        log.info("What do you want to do?");
        log.info("1. Eat laddoos.");
        log.info("2. Leave.");
        System.out.print("Enter your choice : ");
        int choose = scan.nextInt();
        switch(choose) {
        case 1:   
            eatLaddoos();
            break;
        case 2:
            log.info("*******************************************SOUTH");
            game();
            break;
        } // end of switch
    } // end of goSouth

    public static void goEast() {
        if(hasSword) {
            System.out.println();
            log.info("EAST******************************************");
            log.info("You already have the sword.");
            log.info("******************************************EAST");
            game();
        }
        else {
            System.out.println();
            log.info("EAST********************************************");
            log.info("There is a sword on a table.");
            log.info("What do you want to do?");
            log.info("1. Take the sword.");
            log.info("2. Leave.");
            System.out.print("Enter your choice : ");
            int choose = scan.nextInt();
            switch(choose) {
            case 1:
                hasSword = true;
                System.out.println();
                log.info("Sword taken.");
                log.info("********************************************EAST");
                game();
                break;
            case 2:
                log.info("********************************************EAST");
                game();
                break;
            } // end of switch
        }
    } // end of goEast
    
    public static void viewStatus() {
        System.out.println();
        log.info("STATUS******************************************");
        log.info("Your Health   : "+bheemHealth);    
        log.info("Dragon Health : "+dragonHealth);
        log.info("Dragon killed : "+(didKillDragon ? "Killed." : "Not killed."));
        log.info("Sword         : "+(hasSword ? "Has Sword." : "No Sword."));
        log.info("******************************************STATUS");
        game();
    } // end of viewstatus
    
    public static void eatLaddoos() {
        System.out.println();
        log.info("EATING******************************************");
        log.info("Eating laddoos...");
        log.info("Health replenished!");
        log.info("******************************************EATING");
        bheemHealth = 10;
        game();
    } // end of eatLaddoos

    public static void gameOver() {
        System.out.println();
        if(didKillDragon) {
            log.info("################################################");
            log.info("Congratulations!!! You've beaten the game!!!");
            log.info("Welcome to Dholakpur!");
            log.info("################################################");
            System.out.println();
            System.out.println();
            log.info("Thank you for playing my game!");
            System.out.println();
            choose = 0;
        } else {
            if(bheemHealth <= 0 && dragonHealth <= 0) {
                log.info("################################################");
                log.info("GAME OVER! YOU BOTH DIED FIGHTING!");
                log.info("################################################");
                choose = 0;
            } else {
                log.info("################################################");
                log.info("GAME OVER! YOU DIED!");
                log.info("################################################");
                choose = 0;
            }
        }
        System.out.println();
    } // end of gameOver

    public static void fight() {
        System.out.println();
        if(!hasSword) {
            if(bheemHealth == 1) {
                log.info("FIGHTING****************************************");
                log.info("You've woken the dragon from his deep sleep.");
                log.info("Dragon attacked you!");
                log.info("****************************************FIGHTING");
                gameOver();
            } else {
                log.info("FIGHTING****************************************");
                log.info("You've woken the dragon from his deep sleep.");
                log.info("Dragon attacked you! You dealt a lot of damage.");
                log.info("You ran away...");
                log.info("****************************************FIGHTING");
                bheemHealth = 1;
                game();
            }
        } 
        else {
            log.info("FIGHTING****************************************");
            log.info("You've woken the dragon from his deep sleep.");

            fighting();

            if(dragonHealth <= 0) didKillDragon = true;
            if(bheemHealth <= 0) didKillDragon = false;
            log.info("****************************************FIGHTING");
            gameOver();
        }
    } // end of fight

    public static void fighting() {
        if(bheemHealth >= 0 && dragonHealth >= 0) {
            int bheemAttack  = r.nextInt(10) + swordDamage;
            int dragonAttack = r.nextInt(5) + fireBreathDamage;
            bheemHealth  -= dragonAttack;
            dragonHealth -= bheemAttack;
            System.out.printf("Dragon dealt : %02d damage.   Your  health : %02d\n", dragonAttack, bheemHealth);
            System.out.printf(" You   dealt : %02d damage.  Dragon health : %02d\n", bheemAttack, dragonHealth);

            if(bheemHealth <= 0 || dragonHealth <= 0) return;

            log.info("************************************************");
            System.out.print("Press 1 to attack! : ");
            int choose = scan.nextInt();
            log.info("************************************************");
            
            switch(choose) {
            case 1:
                fighting();
            }
        } else return;

    } // end of fighting
} // end of class

/**
   /// PLAYER   : chhota bheem
   /// VILLAIN  : dragon
   /// CHARACTER: soldier

   /// THINGS   : sword, laddoo

   /// DIRECTIONS :
   north : dragon (2: fight/leave)
   south : laddoo (2: eat/leave)
   east  : sword  (2: take sword/leave)
   west  : gate   (2: ask soldier/leave)

   /// VARIABLES :
   bheemHealth
   dragonHealth
   swordDamage
   laddoo       CANCEL
   boolean didKillDragon (true  -> enter Dholakpur, GAME OVER)
   (false -> GAME CONTINUES)


   /// FUNCTIONS :
   game starts at the gate :
   -game()

   -goNorth()
   -goSouth() 
   -goEast()
   -goWest() CANCEL

   -takeSword()
   -eatLaddoo()
   -viewStatus()
   -ask()
   -gameover()
   -fight()

*/
