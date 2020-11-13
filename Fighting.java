import java.util.Random;
import java.util.Scanner;

public class Fighting {

    /*
    static Character newPlayer = new Knight(5, 9,6,10);  //skapar en charactar med namn knight
    static Monster giantSpider = new Giantspider (7, 1, 2, 3, 0.20);
    static Monster skeleton = new Skeleton (4, 2, 3, 3, 0.15);
    static Monster orc = new Orc (6, 3, 4, 4, 0.10);
    static Monster troll = new Troll (2, 4, 7, 2, 0.05);
     */

    public static void getPlayer() {
        for (Classes character : DungeonRunMain.classesList) {
            if ( . ) {
                double agility = character.getAgility();
            }
        }
    }

    public static void getMonster() {

    }


    public static void whoStartsFight() {
        double playerInitiative = rollDice(.getInitiative());
        double monsterInitiative = rollDiceDouble(skeleton.getInitiative());

        while (tryToFlee(newPlayer.getAgility()))
        if (playerInitiative > monsterInitiative) {
            fightingP();
        } else {
            fightingM();
        }
    }
    public static void playerAttack() {
        int playerAttack = rollDice(newPlayer.getAttack());
        double monsterDefend = rollDiceDouble(skeleton.getAgility());

        if (playerAttack > monsterDefend) {
            skeleton.setDurability(skeleton.getDurability() -1);
            System.out.println("The knight swings his sword and HITS!");
            System.out.println("Monster looses one HP");
            System.out.println("HP left: " + skeleton.getDurability());
        } else {
            System.out.println("The knight swings his sword and MISSES!");
            System.out.println("Monster Dodges");
            System.out.println("HP left: " + skeleton.getDurability());
        }
    }

    public static void monsterAttack() {
        double monsterAttack = rollDiceDouble(skeleton.getAttack());
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
        } while (skeleton.getDurability() > 0 && newPlayer.getHealth() > 0);
    }

    public static void fightingP() {
        do {
            playerAttack();
            monsterAttack();
        } while (newPlayer.getHealth() > 0 && skeleton.getDurability() > 0);
    }

    public static boolean tryToFlee(int agility) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int randomGen;
        int chanceToFlee;
        int fleeInput = 0;
        randomGen = rand.nextInt(99) + 1;
        chanceToFlee = agility * 10;

        System.out.println("You see a monster, will you fight or try to flee?\n [1]. Fight [2]. Flee");

        fleeInput = sc.nextInt();

        switch (fleeInput) {
            case 2:
                if (randomGen <= chanceToFlee) {
                    return false;
                } else {
                    return true;
                }
            default:
                return true;
        }
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
    public static double rollDiceDouble(double numberOfDice) {
        double diceThrow;
        double diceTotalScore = 0;
        Random rand = new Random();

        for (int i = 0; i < numberOfDice; i++) {  //numberOfDice == initiativet hos karaktären / monstret

            diceThrow = rand.nextInt(6) + 1;

            //  System.out.println(diceThrow);

            diceTotalScore = diceTotalScore + diceThrow;

        }
        return diceTotalScore;
    }
}
