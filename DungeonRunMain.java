import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


public class DungeonRunMain {

    static ArrayList<Characters> classCharacters = new ArrayList<>();
    static ArrayList<Classes> classesList = new ArrayList<>();



    public static void main(String[] args) {

        Classes knight = new Knight (5, 9, 6, 4);
        Classes wizard = new Wizard (6, 4, 9, 5);
        Classes thief = new Thief (7, 5, 5, 7);
        classesList.add(knight);
        classesList.add(wizard);
        classesList.add(thief);



        boolean mainLoopIsRunning = true;
        int mainMenuChoice;
        welcome();

        while (mainLoopIsRunning == true){
            mainMenuChoice = mainMenuPrint();
            mainMenuSwitch(mainMenuChoice);
            if (mainMenuChoice == 0){
                mainLoopIsRunning = false;
                System.out.println("\tHejdå!");
            }
        }
    }

    public static void mainMenuSwitch(int mainMenuChoice){
        Object chosenCharacterObject = new DungeonRunMain();
        switch (mainMenuChoice){
            case 1:
                //System.out.println("Creating new character");
                ChoosingCharacter.createCharacter();
                Fighting.getMonster();
                break;
            case 2:
                //System.out.println("Loading character");
                chosenCharacterObject = ChoosingCharacter.loadCharacter();

                //String[][] map = MapArray.createMap(MapArray.menuMap());
                String[][] map = MapArray.createMap(MapArray.menuMap());
                Navigate.move(map);
                //MapArray.displayMap(map);
                //String[][] mapPosition = MapArray.enter(MapArray.menu2Map());
                break;
            case 3:
                music();
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

    public static void music(){
        String filePath = "TheAdventureBegins.wav";
        Sound music = new Sound();
        Sound.setMusic(filePath);
    }

    public static int mainMenuPrint(){
        System.out.println("\n\tVälkommen till Dungeon Run!");
        System.out.println("\n\t[1] Skapa en ny karaktär");
        System.out.println("\n\t[2] Ladda en sparad karaktär");
        //System.out.println("\n\t[3] Create a new map");
        System.out.println("\n\t[3] Sätt på eller stäng av musiken");
        System.out.println("\n\t[0] Avsluta program");
        System.out.print("\tVal: ");
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
