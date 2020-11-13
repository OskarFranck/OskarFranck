import java.util.ArrayList;
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
        printSavedCharacter();

        try {
            FileOutputStream fileOut = new FileOutputStream("SavedCharacters.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(classCharacters);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in SavedCharacters.ser");
        } catch (IOException var7) {
            var7.printStackTrace();
        }



    }
    public static void printSavedCharacter() {
        for(Characters savedGuy : classCharacters) {
            System.out.println(savedGuy.toString());
        }
    }

    public static void loadCharacter(){
        try {
            FileInputStream fileIn = new FileInputStream("SavedCharacters.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            DungeonRunMain.classCharacters = (ArrayList)in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException var3) {
            var3.printStackTrace();
        } catch (ClassNotFoundException var4) {
            System.out.println("Employee class not found");
            var4.printStackTrace();
        }

        for (int i = 0; i < DungeonRunMain.classCharacters.size(); i++) {

            System.out.println("Name: " + DungeonRunMain.classCharacters.get(i).getName());
            System.out.println("Total treasure: " + DungeonRunMain.classCharacters.get(i).getTotalTreasure());
            if ((DungeonRunMain.classCharacters.get(i).getClassChoice()) == 1) {
                System.out.println("Klass: Trollkar");
            }

            System.out.println("Class: " + DungeonRunMain.classCharacters.get(i).getClass());

            System.out.println("Monsters slain: " + DungeonRunMain.classCharacters.get(i).getMonstersSlain());
            System.out.println("Total runs: " + DungeonRunMain.classCharacters.get(i).getTotalRuns());
        }


    }
}