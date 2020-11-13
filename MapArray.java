import java.util.Random;

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
    public static String[][] createMap(int choice) {
        String[][] map = new String[0][0];
        Random exitGenerator = new Random();
        if (choice == 1) {              //Karta med 4x4 rum (Yttre arrays bildar väggar)
            String[][] smallMap = new String[6][6];
            System.out.println("This is the Small Map;");
            map = smallMap;
            //Bygga upp rummen
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    map[i][j] = " ☐\t";
                }
            }
            //Placera ut väggarna
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    map[j][0] = " ☠\t";
                    map[j][5] = " ☠\t";
                    map[0][i] = " ☠\t";
                    map[5][i] = " ☠\t";
                }
            }
            //Placera en utgång
            int full = map.length - 2;
            int randomIntX = 1 + exitGenerator.nextInt(full);
            int randomIntY = 1 + exitGenerator.nextInt(full);
            map[randomIntX][randomIntY] = " ♨\t";
        } else if (choice == 2) {       //Karta med 5x5 rum
            String[][] mediumMap = new String[7][7];
            System.out.println("This is the Medium Map;");
            map = mediumMap;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    map[i][j] = " ☐\t";
                }
            }
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    map[j][0] = " ☠\t";
                    map[j][6] = " ☠\t";
                    map[0][i] = " ☠\t";
                    map[6][i] = " ☠\t";
                }
            }
            int full = map.length - 2;
            int randomIntX = 1 + exitGenerator.nextInt(full);
            int randomIntY = 1 + exitGenerator.nextInt(full);
            map[randomIntX][randomIntY] = " ♨\t";
        } else if (choice == 3) {       //Karta med 8x8 rum
            String[][] bigMap = new String[10][10];
            System.out.println("This is the Big Map;");
            map = bigMap;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    map[i][j] = " ☐\t";
                }
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    map[j][0] = " ☠\t";
                    map[j][9] = " ☠\t";
                    map[0][i] = " ☠\t";
                    map[9][i] = " ☠\t";
                }
            }
            int full = map.length - 2;
            int randomIntX = 1 + exitGenerator.nextInt(full);
            int randomIntY = 1 + exitGenerator.nextInt(full);
            map[randomIntX][randomIntY] = " ♨\t";
        } else {
            System.out.println("No valid Map-choice");
        }
        displayMap(map);
        enterMap(map);
        return map;
    }

    //Metod för att enbart skriva ut kartan
    public static void displayMap(String[][] map){
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                System.out.print(map[row][column] + "");
            }
            System.out.println();
        }
    }

    // Start
    public static String[][] enterMap(String[][] map){
        int choice = menu2Map();
        if (choice == 1) {
            //Startar äventyret från övre vänstra rummet | Testar även programmet som ett litert äventyr
            map [1][1] = " ⚜️\t";
        } else if (choice == 2) {
            //Startar äventyret från övre högra rummet
            map [1][map.length-2] = " ⚜️\t";
        } else if (choice == 3) {
            //Startar äventyret från nedre vänstra rummet
            map [map.length-2][1] = " ⚜️\t";
        } else if (choice == 4) {
            //Startar äventyret från nedre högra rummet
            map [map.length-2][map.length-2] = " ⚜️\t";
        } else {
            System.out.println("No valid Entry");
        }
        displayMap(map);
        return map;
    }

    //Old mapcode
    /*public static int[][] createMap(int choice) {
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
    }*/

    public static int menuMap(){
        System.out.println("\nChoose the size of your map:");
        System.out.println("[1] Small Map");
        System.out.println("[2] Medium Map");
        System.out.println("[3] Big Map");
        System.out.println("[0] Exit");
        System.out.println("\nChoose: ");
        int choice = DungeonRunMain.intInputMethod();
        return choice;
    }

    public static int menu2Map(){
        System.out.println("\nSelect your starting position by typing in one of the following rooms: ");
        System.out.println("[1] Top Left Room");
        System.out.println("[2] Top Right Room");
        System.out.println("[3] Bottom Left Room");
        System.out.println("[4] Bottom Right Room");
        System.out.println("[0] Exit");
        System.out.println("\nChoose: ");
        //Denna metod kallas på i Mainmetoden för att bruka Scanner.
        int choice = DungeonRunMain.intInputMethod();
        return choice;
    }
}