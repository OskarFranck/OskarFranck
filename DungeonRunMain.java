import java.util.InputMismatchException;
import java.util.Scanner;

public class DungeonRunMain {

    public static void main(String[] args) {
        boolean mainLoopIsRunning = true;
        int mainMenuChoice;
        welcome();

        while (mainLoopIsRunning == true){
            mainMenuChoice = mainMenuPrint();
            mainMenuSwitch(mainMenuChoice);
            if (mainMenuChoice == 0){
                mainLoopIsRunning = false;
                System.out.println("\tGoodbye!");
            }
        }
    }

    public static void mainMenuSwitch(int mainMenuChoice){
        switch (mainMenuChoice){
            case 1:
                System.out.println("Creating new character");
                break;
            case 2:
                System.out.println("Loading character");
                break;

            case 3:
                //String[][] map = MapArray.createMap(MapArray.menuMap());
                String[][] map = MapArray.createMap(MapArray.menuMap());
                Navigate.move(map);
                //MapArray.displayMap(map);
                //String[][] mapPosition = MapArray.enter(MapArray.menu2Map());
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("\n\tError: please insert a valid number from the menu shown");
                break;
        }
    }

    public static void welcome(){   //Version av Dungeon Run
        System.out.println("\n\n\t\t\t\t\t\t   ⚜️\t\t");
        System.out.println("\t\t   ---  ===  \uD835\uDD3B\uD835\uDD4Cℕ\uD835\uDD3E\uD835\uDD3C\uD835\uDD46ℕ ℝ\uD835\uDD4Cℕ®  ===  ---   \t\t");
        System.out.println("\t\t\t\t\t \uD835\uDD7F\uD835\uDD8D\uD835\uDD8A \uD835\uDD6C\uD835\uDD89\uD835\uDD9B\uD835\uDD8A\uD835\uDD93\uD835\uDD99\uD835\uDD9A\uD835\uDD97\uD835\uDD8A \t\t");
        System.out.println();
        System.out.println("\t\t\t\t༄  Version (1.0004)  ❦\n");
    }

    public static int mainMenuPrint(){
        System.out.println("\n\tWelcome to Dungeon Run");
        System.out.println("\n\t[1] Create new character");
        System.out.println("\n\t[2] Load an existing character");
        System.out.println("\n\t[3] Create a new map");
        System.out.println("\n\t[0] Exit program");
        System.out.print("\tAccess menu: ");
        int mainMenuChoice = intInputMethod();
        return mainMenuChoice;
    }

    public static int intInputMethod(){
            int userInput;
            try{
                Scanner sc = new Scanner(System.in);
                userInput = sc.nextInt();
                return userInput;
            } catch (InputMismatchException allExceptions){
                return userInput = 9;
            }
    }

    public static void exit() {
        System.out.println("Exiting the dungeon.");
    }

}