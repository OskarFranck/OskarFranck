import java.util.Random;

public class Treasuregenerator {

    static int treasureCollected = 0;

    public static int treasureGenerator() {

        Random numberOfTreasures = new Random();
        int upperbound = 4;
        int upperbound2 = 99;

        int randomInt = numberOfTreasures.nextInt(upperbound);

        int coin = 2;
        int purse = 6;
        int jewelry = 10;
        int gemstone = 14;
        int treasure = 20;

        for (int i = 0; i < randomInt; i++) {

            int randomInt2 = numberOfTreasures.nextInt(upperbound2);

            if(randomInt2 <= 39) {
                //System.out.println("Generated number = " + randomInt2);
                treasureCollected += coin;
                System.out.println("\tYou found some coins valued: " + coin);
            } else if (randomInt2 <= 59) {
                //System.out.println("Generated number = " + randomInt2);
                treasureCollected += purse;
                System.out.println("\tYou found a purse valued: " + purse);
            } else if (randomInt2 <= 74) {
               // System.out.println("Generated number = " + randomInt2);
                treasureCollected += jewelry;
                System.out.println("\tYou found some jewelry valued: " + jewelry);
            } else if (randomInt2 <= 84) {
               // System.out.println("Generated number = " + randomInt2);
                treasureCollected += gemstone;
                System.out.println("\tYou found a gemstone valued: " + gemstone);
            } else if (randomInt2 <= 89) {
               // System.out.println("Generated number = " + randomInt2);
                treasureCollected += treasure;
                System.out.println("\tYou found a small treasure chest valued: " + treasure);
            } else {
             //   System.out.println("random = " + randomInt2);
                System.out.println("\tYou found JACKSHIT!");
            }
        }

        System.out.println("\tTotal treasure found in the room: " + treasureCollected);
        return treasureCollected;
    }
}