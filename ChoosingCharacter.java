import java.util.ArrayList;
import java.io.*;
public class ChoosingCharacter extends DungeonRunMain{


    public static void saveCurrentCharacter(){
        try {
            FileInputStream fileIn = new FileInputStream("SavedCharacters.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            DungeonRunMain.classCharacters = (ArrayList)in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException var3) {
            //var3.printStackTrace();
        } catch (ClassNotFoundException var4) {
            System.out.println("Did not find character");
            //var4.printStackTrace();
        }
    }

    public static void createCharacter(){



            try {
                FileInputStream fileIn = new FileInputStream("SavedCharacters.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                DungeonRunMain.classCharacters = (ArrayList)in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException var3) {
                //var3.printStackTrace();
            } catch (ClassNotFoundException var4) {
                System.out.println("Did not find character");
                //var4.printStackTrace();
            }





        boolean characterClassLoop = true;
        boolean characterClassLoop2 = true;
        int characterClass = 0;
        String name = "";
        int check = 0;

        while(characterClassLoop){
            System.out.println("\tChoose your class: ");
            System.out.println("\t[0] Knight" + DungeonRunMain.classesList.get(0).toString());
            System.out.println("\t[1] Wizard" + DungeonRunMain.classesList.get(1).toString());
            System.out.println("\t[2] Thief" + DungeonRunMain.classesList.get(2).toString());
            System.out.print("\tChoice: ");
            characterClass = intInputMethod();
            if (characterClass>2 || characterClass<0){
                System.out.println("\tError: invalid input");
            }
            else {
                characterClassLoop=false;
            }
        }

        while(characterClassLoop2){
            check = 0;
            System.out.print("\tEnter your characters name: ");
            name = DungeonRunMain.lineInputMethod();
            if(DungeonRunMain.classCharacters.isEmpty()){
                characterClassLoop2 =false;
            }else{
                for (int i = 0; i < DungeonRunMain.classCharacters.size(); i++) {
                    if(name.equalsIgnoreCase(DungeonRunMain.classCharacters.get(i).getName())){
                        check ++;
                    }
                }
                if (check == 0){
                    characterClassLoop2 = false;
                }
                else{
                    System.out.println("\tName already exists, you must go your own path! And create your own legacy " + name + " from guild: " + DungeonRunMain.classesList.get(characterClass).getClass().toString() + "...");
                }
            }
        }

        Characters freshCharacter = new SavedCharacters(name, 0, characterClass, 0, 0);
        DungeonRunMain.classCharacters.add(freshCharacter);

        try {
            FileOutputStream fileOut = new FileOutputStream("SavedCharacters.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(DungeonRunMain.classCharacters);
            out.close();
            fileOut.close();
        } catch (IOException var7) {
            //var7.printStackTrace();
        }
    }

    public static int loadCharacter(){

        boolean loopIsRunning = true;
        int characterChoice = 0;
        try {
            FileInputStream fileIn = new FileInputStream("SavedCharacters.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            DungeonRunMain.classCharacters = (ArrayList)in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException var3) {
            //var3.printStackTrace();
        } catch (ClassNotFoundException var4) {
            System.out.println("\tDid not find any characters");
            //var4.printStackTrace();
        }

        while (loopIsRunning){


            for (int i = 0; i < DungeonRunMain.classCharacters.size(); i++) {

                System.out.print("\n\t" +"["+ (i) +"]"+ " | Name: " + DungeonRunMain.classCharacters.get(i).getName());
                System.out.print(" | Total treasure: " + DungeonRunMain.classCharacters.get(i).getTotalTreasure());
                if ((DungeonRunMain.classCharacters.get(i).getClassChoice()) == 0) System.out.print(" | Class: Riddare");
                else if(((DungeonRunMain.classCharacters.get(i).getClassChoice())) == 1)System.out.print(" | Class: Trollkar");
                else if(((DungeonRunMain.classCharacters.get(i).getClassChoice())) == 2) System.out.print(" | Class: Tjuv    ");
                System.out.print(" | Monsters slain: " + DungeonRunMain.classCharacters.get(i).getMonstersSlain());
                System.out.print(" | Total runs: " + DungeonRunMain.classCharacters.get(i).getTotalRuns()+ "|");
                System.out.print("\n");
            }
            System.out.print("\tIndex choice: ");
            characterChoice = DungeonRunMain.intInputMethod();
            if (characterChoice<0||characterChoice>DungeonRunMain.classCharacters.size()){
                System.out.println("\tDid not find a matching index");
            }
            else {
                loopIsRunning = false;
            }
        }
        return characterChoice;
    }
}