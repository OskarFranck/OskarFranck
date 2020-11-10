import java.util.Random;

public class Fighting {
    static Character newPlayer = new Knight(5, 9,6,4);  //skapar en charactar med namn knight
    static Monster newMonster = new Skeleton(4, 2, 3, 3, 1); //skapar ett monster med namn skeleton


    public static void whoStartsFight() {
        int playerInitiative = rollDice(newPlayer.getInitiative());
        int monsterInitiative = rollDice(newMonster.getInitiative());

        if (playerInitiative > monsterInitiative) {
            fightingP();
        } else {
            fightingM();
        }
    }
    public static void playerAttack() {
        int playerAttack = rollDice(newPlayer.getAttack());
        int monsterDefend = rollDice(newMonster.getAgility());

        if (playerAttack > monsterDefend) {
            newMonster.setHealth(newMonster.getHealth() -1);
            System.out.println("The knight swings his sword and HITS!");
            System.out.println("Monster looses one HP");
            System.out.println("HP left: " + newMonster.getHealth());
        } else {
            System.out.println("The knight swings his sword and MISSES!");
            System.out.println("Monster Dodges");
            System.out.println("HP left: " + newMonster.getHealth());
        }
    }

    public static void monsterAttack() {
        int monsterAttack = rollDice(newMonster.getAttack());
        int playerDefend = rollDice(newPlayer.getAgility());

        if (monsterAttack > playerDefend) {
            newPlayer.setHealth(newPlayer.getHealth() -1);
            System.out.println("Player looses one HP");
            System.out.println("HP left: " + newPlayer.getHealth());
        } else {
            System.out.println("Player dodges");
            System.out.println("HP left: " + newPlayer.getHealth());
        }
    }
    public static void fightingM() {
        do {
            monsterAttack();
            playerAttack();
        } while (newMonster.getHealth() > 0 && newPlayer.getHealth() > 0);
    }

    public static void fightingP() {
        do {
            playerAttack();
            monsterAttack();
        } while (newPlayer.getHealth() > 0 && newMonster.getHealth() > 0);
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
