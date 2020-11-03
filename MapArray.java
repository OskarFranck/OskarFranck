/*        Kartor
        Kartorna är uppbyggda som matriser med koordinater, ungefär som ett schackbräde. I
        programmering kallas detta för ”multi-dimensional arrays”, läs mer här:
        http://www.homeandlearn.co.uk/java/multi-dimensional_arrays.html
[X] [X] [X] [X]
[X] [X] [X] [X]
[X] [X] [X] [X]
[X] [X] [X] [X]
[X] = ett rum på kartan.
        Spelaren ska kunna välja storlek på kartan vid varje nytt äventyr enligt följande:
• Liten = 4x4 rum
• Lagom = 5x5 rum
• Stor = 8x8 rum*/
public class MapArray {

    //2. Nästa steg är att starta ett äventyr. Spelaren väljer storlek på äventyret; litet, lagom eller stort
    //Valen för detta hittas i metoden Menu
    public static int[][] createMap(int choice) {
        //Creating the map as an multi-dimensional array
        int[][] map = {{}};
        if (choice == 1) {
            int[][] smallMap = {{11, 12, 13, 14}, {21, 22, 23, 24}, {31, 32, 33, 34}, {41, 42, 43, 44}};
            System.out.println("This is the Small Map;");
            map = smallMap;
        } else if (choice == 2) {
            int[][] mediumMap = {{11, 12, 13, 14, 15}, {21, 22, 23, 24, 25}, {31, 32, 33, 34, 35}, {41, 42, 43, 44, 45}, {51, 52, 53, 54, 55}};
            System.out.println("This is the Medium Map;");
            map = mediumMap;
        } else if (choice == 3) {
            int[][] bigMap = {{11, 12, 13, 14, 15, 16, 17, 18}, {21, 22, 23, 24, 25, 26, 27, 28}, {31, 32, 33, 34, 35, 36, 37, 38}, {41, 42, 43, 44, 45, 46, 47, 48}, {51, 52, 53, 54, 55, 56, 57, 58}, {61, 62, 63, 64, 65, 66, 67, 68}, {71, 72, 73, 74, 75, 76, 77, 78}, {81, 82, 83, 84, 85, 86, 87, 88}};
            System.out.println("This is the Big Map;");
            map = bigMap;
        } else {
            System.out.println("No valid Map-choice");
        }
        return map;
    }

    //Metod för att enbart skriva ut kartan
    public static void displayMap(int x[][]) {
        for(int row=0;row<x.length;row++){
            for (int column=0;column<x[row].length;column++){
                System.out.print(x[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] enter(int choice2){

        if (choice2 == 1) {
            //Startar äventyret från övre vänstra rummet | Testar även programmet som ett litert äventyr
            int[][] mapPosition = {{1},{1}};
            System.out.println("Displays map position: top left room = " + mapPosition[0][0]);
            return mapPosition;
        } else if (choice2 == 2) {
            //Startar äventyret från övre högra rummet
            int[][] mapPosition = {{1},{4}};
            System.out.println("Displays top right room");
            return mapPosition;
        } else if (choice2 == 3) {
            //Startar äventyret från nedre vänstra rummet
            int[][] mapPosition = {{4},{1}};
            System.out.println("Displays bottom left room");
            return mapPosition;
        } else if (choice2 == 4) {
            //Startar äventyret från nedre högra rummet
            int[][] mapPosition = {{4},{4}};
            System.out.println("Displays bottom right room");
            return mapPosition;
        } else {
            System.out.println("No valid Entery");
            return null;
        }
    }
        /*
        switch (choice2) {

            case 1:
                //Startar äventyret från övre vänstra rummet
                System.out.println("Displays top left room");
                int mapPosition;
                break;

            case 2:
                //Startar äventyret från övre högra rummet
                System.out.println("Displays top right room");
                break;

            case 3:
                //Startar äventyret från nedre vänstra rummet
                System.out.println("Displays bottom left room");
                break;

            case 4:
                //Startar äventyret från nedre högra rummet
                System.out.println("Displays bottom right room");
                break;

            case 0:
                //loop = false;
                System.out.println("- QUIT -");
                break;

            default:
                System.out.println("Assertion Error!");

        }*/

    public static int menu(){
        System.out.println("\nChoose the size of your map:");
        System.out.println("[1] Small Map");
        System.out.println("[2] Medium Map");
        System.out.println("[3] Big Map");
        System.out.println("[0] Exit");
        System.out.println("\nChoose: ");
        int choice = Main.intInputMethod();

        return choice;
    }

    public static int menu2(){
        System.out.println("\nSelect your position by typing in one of the following rooms: ");
        System.out.println("[1] Top Left Room");
        System.out.println("[2] Top Right Room");
        System.out.println("[3] Bottom Left Room");
        System.out.println("[4] Bottom Right Room");
        System.out.println("[0] Exit");
        System.out.println("\nChoose: ");
        //Denna metod kallas på i Mainmetoden för att bruka Scanner.
        int choice2 = Main.intInputMethod();

        return choice2;
    }


    //        4. Spelaren väljer åt vilket håll hen vill gå för att komma till ett nytt rum
    //        Skapa en klass som kan navigera mellan rummen

}