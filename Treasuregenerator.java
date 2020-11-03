import java.util.Random;

public class Treasuregenerator {

    public static int treasureGenerator() {

        Random numberOfTreasures = new Random();
        int upperbound = 6;
        int upperbound2 = 99;

        int randomInt = numberOfTreasures.nextInt(upperbound);

        int treasureCollected = 0;

        int coin = 2;
        int purse = 6;
        int jewelry = 10;
        int gemstone = 14;
        int treasure = 20;

        for (int i = 0; i < randomInt; i++) {

            int randomInt2 = numberOfTreasures.nextInt(upperbound2);

            if(randomInt2 <= 39) {
                System.out.println("Generated number = " + randomInt2);
                treasureCollected += coin;
                System.out.println("You found some coins");
            } else if (randomInt2 <= 59) {
                System.out.println("Generated number = " + randomInt2);
                treasureCollected += purse;
                System.out.println("You found a purse");
            } else if (randomInt2 <= 74) {
                System.out.println("Generated number = " + randomInt2);
                treasureCollected += jewelry;
                System.out.println("You found some jewelry");
            } else if (randomInt2 <= 84) {
                System.out.println("Generated number = " + randomInt2);
                treasureCollected += gemstone;
                System.out.println("You found a gemstone");
            } else if (randomInt2 <= 89) {
                System.out.println("Generated number = " + randomInt2);
                treasureCollected += treasure;
                System.out.println("You found a small treasurechest");
            } else {
                System.out.println("random = " + randomInt2);
                System.out.println("You found JACKSHIT!");
            }
        }

        System.out.println("Score of treasures: " + treasureCollected);

        return treasureCollected;
    }
}