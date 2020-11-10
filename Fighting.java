import java.util.Random;

public class Fighting {
    static Character newPlayer = new Knight(5, 9,6,4);  //skapar en charactar med namn knight
    static Monster newMonster = new Skeleton(4, 5, 3, 3, 1); //skapar ett monster med namn skeleton


    public static void playerStartsFight() {

    }

    public static void monsterStartFight() {

    }

    public static void fighting() {
        do {

        } while (newPlayer.getHealth() > 0 || newMonster.getHealth() > 0);
    }


    public static int rollDice(int numberOfDice) {
        int diceThrow;
        int diceTotalScore = 0;
        Random rand = new Random();

        for (int i = 0; i < numberOfDice; i++) {  //numberOfDice == initiativet hos karaktären / monstret

            diceThrow = rand.nextInt(6) + 1;

            //  System.out.println(diceThrow);

            diceTotalScore = diceTotalScore + diceThrow;

        }
        return diceTotalScore;
    }
}
