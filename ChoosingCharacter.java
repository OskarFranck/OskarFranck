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
            name = sc.nextLine();
        }
        Characters freshCharacter = new SavedCharacters(name, 0, characterClass, 0, 0);
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("B:/Dokument/Downloads/[standard] Skolarbeten/Högskola/Java Utvecklare/Java A projects//Dungeon-Run/SparadeKaraktärer.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(freshCharacter);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in B:/Dokument/Downloads/[standard] Skolarbeten/Högskola/Java Utvecklare/Java A projects//Dungeon-Run/SparadeKaraktärer.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
        classCharacters.add(freshCharacter);
        printSavedCharacter();


    }
    public static void printSavedCharacter() {
        for(Characters savedGuy : classCharacters) {
            System.out.println(savedGuy.toString());
        }
    }
    /*
    public static void loadCharacter(){

        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }

     */
}
