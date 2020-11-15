import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class ChoosingCharacter extends DungeonRunMain{




    public static void createCharacter(){
        Scanner sc = new Scanner(System.in);
        boolean characterClassLoop = true;
        int characterClass = 0;
        String name = "";

        while(characterClassLoop){
            System.out.println("Välj typ av karaktär: ");
            System.out.println("[1] Riddare");
            System.out.println("[2] Trollkarlen");
            System.out.println("[3] Tjuven");
            System.out.print("Val: ");
            characterClass = intInputMethod();
            if (characterClass>3 || characterClass<1){
                System.out.println("Felaktig inamtning");
            }
            else {
                characterClassLoop=false;
            }
            System.out.println("Skriv in karaktärens namn: ");
            name = sc.next();
        }
        Characters freshCharacter = new SavedCharacters(name, 0, characterClass, 0, 0);
        classCharacters.add(freshCharacter);

        try {
            FileOutputStream fileOut = new FileOutputStream("SavedCharacters.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(classCharacters);
            out.close();
            fileOut.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }



    }

    public static Object loadCharacter(){

        boolean loopIsRunning = true;
        int characterChoice = 0;
        try {
            FileInputStream fileIn = new FileInputStream("SavedCharacters.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            DungeonRunMain.classCharacters = (ArrayList)in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException var3) {
            var3.printStackTrace();
        } catch (ClassNotFoundException var4) {
            System.out.println("Hittade inga karaktärer");
            var4.printStackTrace();
        }

        while (loopIsRunning){


            for (int i = 0; i < DungeonRunMain.classCharacters.size(); i++) {

                System.out.print("\n\t" +"["+ (i+1) +"]"+ " | Name: " + DungeonRunMain.classCharacters.get(i).getName());
                System.out.print(" | Total treasure: " + DungeonRunMain.classCharacters.get(i).getTotalTreasure());
                if ((DungeonRunMain.classCharacters.get(i).getClassChoice()) == 1) System.out.print(" | Klass: Riddare");
                else if(((DungeonRunMain.classCharacters.get(i).getClassChoice())) == 2)System.out.print(" | Klass: Trollkar");
                else if(((DungeonRunMain.classCharacters.get(i).getClassChoice())) == 3) System.out.print(" | Klass: Tjuv    ");
                System.out.print(" | Monsters slain: " + DungeonRunMain.classCharacters.get(i).getMonstersSlain());
                System.out.print(" | Total runs: " + DungeonRunMain.classCharacters.get(i).getTotalRuns()+ "|");
                System.out.print("\n");
            }
            System.out.print("\tIndex val: ");
            characterChoice = intInputMethod();
            if (characterChoice<1||characterChoice>DungeonRunMain.classCharacters.size()){
                System.out.println("\tHittade inte ett matchande index");
            }
            else {
                loopIsRunning = false;
            }
        }

        return DungeonRunMain.classCharacters.get(characterChoice);

    }
    public static int intInputMethod(){
        int userInput;
        try{
            Scanner sc = new Scanner(System.in);
            userInput = sc.nextInt();
            return userInput;
        } catch (InputMismatchException allExceptions){
            return userInput = -1;
        }
    }
}
