import java.util.InputMismatchException;
import java.util.Scanner;

public class DungeonRunMain {

    public static void main(String[] args) {
        boolean mainLoopIsRunning = true;
        int mainMenuChoice;

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
                int[][] map = MapArray.createMap(MapArray.menuMap());
                MapArray.displayMap(map);
                int[][] mapPosition = MapArray.enter(MapArray.menu2Map());

                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("\n\tError: please insert a valid number from the menu shown");
                break;
        }
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