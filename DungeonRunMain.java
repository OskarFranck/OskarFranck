import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


public class DungeonRunMain {

    static ArrayList<Characters> classCharacters = new ArrayList<>();//Detta är alla dina sparade karraktärer
    static ArrayList<Classes> classesList = new ArrayList<>();//Detta är alla aktuella spelar-klasser du kan välja
    static int indexChoice;

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
                System.out.println("\tGoodbye!");
            }
        }
    }

    public static void mainMenuSwitch(int mainMenuChoice){
        int index = 0;

        switch (mainMenuChoice){
            case 1:
                ChoosingCharacter.createCharacter();
                break;
            case 2:
                indexChoice = ChoosingCharacter.loadCharacter();
                System.out.println(indexChoice);

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
                System.out.println("\n\tError: please insert something from the menu shown");
                break;
        }
    }


    public static void welcome(){   //Version av Dungeon Run
        System.out.println("\n\n\t\t\t\t\t\t   ⚜️\t\t");
        System.out.println("\t\t   ---  ===  \uD835\uDD3B\uD835\uDD4Cℕ\uD835\uDD3E\uD835\uDD3C\uD835\uDD46ℕ ℝ\uD835\uDD4Cℕ®  ===  ---   \t\t");
        System.out.println("\t\t\t\t\t \uD835\uDD7F\uD835\uDD8D\uD835\uDD8A \uD835\uDD6C\uD835\uDD89\uD835\uDD9B\uD835\uDD8A\uD835\uDD93\uD835\uDD99\uD835\uDD9A\uD835\uDD97\uD835\uDD8A \t\t");
        System.out.println();
        //System.out.println("\t\t\t\t༄  Version (1.0004)  ❦\n");
    }

    public static void music(){
        String filePath = "TheAdventureBegins.wav";
        Sound music = new Sound();
        Sound.setMusic(filePath);
    }

    public static int mainMenuPrint(){
        System.out.println("\n\tWelcome to Dungeon Run");
        System.out.println("\n\t[1] Create new character");
        System.out.println("\n\t[2] Load existing character");
        System.out.println("\n\t[3] Turn on/off the music");
        System.out.println("\n\t[0] Exit program");
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
    //Detta är en ny String-metod för inmatning i menyerna
    public static String lineInputMethod(){
        String userInput;
        try{
            Scanner sc = new Scanner(System.in);
            userInput = sc.next();
            return userInput;
        } catch (Exception allExceptions){
            System.out.println("\t\nError: only text is allowed");
            return userInput = "";
        }
    }

    public static void exit() {
        System.out.println("\tExiting the dungeon.\n\tGoodbye!");
        System.exit(0);
    }
}