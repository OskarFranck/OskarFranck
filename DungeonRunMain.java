package com.company;
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

                break;
            case 2:

                break;
            case 0:

                break;
            default:
                System.out.println("\tError: please insert a valid number from the menu shown");
                break;
        }
    }

    public static int mainMenuPrint(){
        System.out.println("\n\tWelcome to Dungeon Run");
        System.out.println("\n\t[1] Create new character");
        System.out.println("\t[2] Load an existing character");
        System.out.println("\t[0] Exit program");
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

            } catch (Exception allExceptions){
                System.out.println("\t\nError: please insert a valid number from the menu shown");
                return userInput = 0;
            }
    }
}