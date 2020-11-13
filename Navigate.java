public class Navigate {

    public static String[][] move (String[][] map){
        int choice = menuNav();
        //Read more: https://javarevisited.blogspot.com/2015/09/how-to-loop-two-dimensional-array-in-java.html#ixzz6dIlWV2uu
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++){
                if (" ⚜️\t".equals(map[row][col])) {
                    if (choice == 1) {                  // ◄ - Go Left
                        if (map[row][col - 1].equals(" ☠\t")){
                            System.out.println("⌧ You can't walk here! ☞ ☠");
                        } else if (map[row][col - 1].equals(" ♨\t")){
                            System.out.println("Would you like to escape the dungeon? ☞ ♨");
                        } else {
                            map[row][col] = " ☑\t";
                            map[row][col - 1] = " ⚜️\t";
                            Room.enterRoom();
                        }
                    } else if (choice == 2) {           // △ - Go Up
                        if (map[row - 1][col].equals(" ☠\t")){
                            System.out.println("⌧ You can't walk here! ☞ ☠");
                        } else if (map[row - 1][col].equals(" ♨\t")){
                            System.out.println("Would you like to escape the dungeon? ☞ ♨");
                        } else {
                            map[row][col] = " ☑\t";
                            map[row - 1][col] = " ⚜️\t";
                            Room.enterRoom();
                        }
                    } else if (choice == 3) {           // ► - Go Right
                        if (map[row][col + 1].equals(" ☠\t")){
                            System.out.println("⌧ You can't walk here! ☞ ☠");
                        } else if (map[row][col + 1].equals(" ♨\t")){
                            System.out.println("Would you like to escape the dungeon? ☞ ♨");
                        }  else {
                            map[row][col] = " ☑\t";
                            col++;
                            map[row][col] = " ⚜️\t";
                            Room.enterRoom();
                        }
                    } else if (choice == 4) {           // ▽ - Go Down
                        if (map[row + 1][col].equals(" ☠\t")){
                            System.out.println("⌧ You can't walk here! ☞ ☠");
                        } else if (map[row + 1][col].equals(" ♨\t")){
                            System.out.println("Would you like to escape the dungeon? ☞ ♨");
                        } else {
                            map[row][col] = " ☑\t";
                            row++;
                            map[row][col] = " ⚜️\t";
                            Room.enterRoom();
                        }
                    } else if (choice == 0) {
                        DungeonRunMain.exit();
                    }
                }
            }
        }
        MapArray.displayMap(map);
        move(map);//Tillfällig loop som navigerar om och om igen. Här kan vi placera if-loop som kollar livet för karraktären.
        return map;
    }

    //Navigeringsmenyn som låter spelaren gå med sin karraktär
    public static int menuNav(){
        int choice;
        do {
            System.out.println("\nNavigate using numbers: ");
            System.out.println("\t\t  ②");
            System.out.println("\t\t  ☝");
            System.out.println("\t ① ☜ ✧ ☞ ③");
            System.out.println("\t\t  ☟");
            System.out.println("\t\t  ④");
            /*System.out.println("[1] Go left!");
            System.out.println("[2] Go up!");
            System.out.println("[3] Go right!");
            System.out.println("[4] Go down!");*/
            System.out.println("[0] Escape the dungeon!");
            System.out.println("\nChoose: ");
            choice = DungeonRunMain.intInputMethod(); //Denna metod kallas på i Mainmetoden för att bruka Scanner.

            String filePath = "move.wav";   //kod som kallar på navigeringsljud
            Sound soundNav = new Sound();
            Sound.setFx(filePath);
        } while (choice < 0 || choice > 4);
        return choice;
    }
}
