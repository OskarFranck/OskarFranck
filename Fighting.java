import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fighting {


    static Monster giantSpider = new Giantspider (7, 1, 2, 3, 0.20);
    static Monster skeleton = new Skeleton (4, 2, 3, 3, 0.15);
    static Monster orc = new Orc (6, 3, 4, 4, 0.10);
    static Monster troll = new Troll (2, 4, 7, 2, 0.05);

    static Classes newPlayer = null;

    /*
    1. riddare
    2. trollkarl
    3. tjuv
     */


    public static Classes getPlayer() {
        for (int i = 0; i < DungeonRunMain.classesList.size(); i++) {
            if (DungeonRunMain.classesList.get(i) instanceof Knight) {
                newPlayer = DungeonRunMain.classesList.get(i);
            } else if (DungeonRunMain.classesList.get(i) instanceof Wizard) {
                newPlayer = DungeonRunMain.classesList.get(i);
            } else if (DungeonRunMain.classesList.get(i) instanceof Thief) {
                newPlayer = DungeonRunMain.classesList.get(i);
            }
        }
        return newPlayer;
    }

    public static ArrayList<Monster> getMonster() {

        return GenerateMonster.randomMonster();
    }



    public static void whoStartsFight() {
        double playerInitiative = rollDice(getPlayer().getInitiative());
        double monsterInitiative = rollDice(getMonster().getInitiative());

        while (tryToFlee(getPlayer().getAgility()))
        if (playerInitiative > monsterInitiative) {
            fightingP();
        } else {
            fightingM();
        }
    }

    public static void playerAttack() {
        double playerAttack = rollDice(newPlayer.getAttack());
        double monsterDefend = rollDice(skeleton.getAgility());

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
        double monsterAttack = rollDice(skeleton.getAttack());
        double playerDefend = rollDice(newPlayer.getAgility());

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

    public static boolean tryToFlee(double agility) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int randomGen;
        double chanceToFlee;
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


    /*
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

     */
    public static double rollDice(double numberOfDice) {
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
