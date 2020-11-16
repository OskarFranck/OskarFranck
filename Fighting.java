import java.util.*;

public class Fighting extends GenerateMonster{

    /*
    static Monster giantSpider = new Giantspider (7, 1, 2, 3, 0.20);
    static Monster skeleton = new Skeleton (4, 2, 3, 3, 0.15);
    static Monster orc = new Orc (6, 3, 4, 4, 0.10);
    static Monster troll = new Troll (2, 4, 7, 2, 0.05);
    */

    static Classes newPlayer = null;
    static ArrayList<Integer> orderForFight = new ArrayList<>();

    /*
    1. riddare
    2. trollkarl
    3. tjuv
    */


    public static Classes getPlayer() {
        for (int i = 0; i < DungeonRunMain.classesList.size(); i++) {
            if (DungeonRunMain.classesList.get(i) instanceof Knight) {
                newPlayer = DungeonRunMain.classesList.get(i);
                break;
            } else if (DungeonRunMain.classesList.get(i) instanceof Wizard) {
                newPlayer = DungeonRunMain.classesList.get(i);
                break;
            } else if (DungeonRunMain.classesList.get(i) instanceof Thief) {
                newPlayer = DungeonRunMain.classesList.get(i);
                break;
            }
        }
        return newPlayer;
    }

    public static void getMonster() {
        GenerateMonster.monster.clear();
        GenerateMonster.monster = GenerateMonster.randomMonster();

        for (int i = 0; i < GenerateMonster.monster.size(); i++) {
            if (GenerateMonster.monster.get(i) != null) {
                System.out.println("There is something lurking in the room...");
                whoStartsFight(GenerateMonster.monster, getPlayer());
                break;
            } else if (i == GenerateMonster.monster.size() -1 ) {
                System.out.println("The room seams to be empty");
            }
        }
    }

    public static void whoStartsFight(ArrayList<Monster> monster, Classes newPlayer) {
        int attackOrder =0;
        orderForFight.clear();

        for (int j = 0; j < newPlayer.getInitiative(); j++) {
            attackOrder += rollDice(1);
        }
        orderForFight.add(attackOrder);

        for (int i = 0; i < monster.size(); i++) {
            attackOrder = 0;

            for (int j = 0; j < monster.get(i).getInitiative(); j++) {
                attackOrder += rollDice(1);
            }
            orderForFight.add(attackOrder);
        }

        Comparator c = Collections.reverseOrder();
        Collections.sort(orderForFight, c);
        System.out.println(orderForFight);

    }

    /*
    public static void playerAttack() {
        ArrayList<Monster> monsters;
        double playerAttack = rollDice(newPlayer.getAttack());
        double monsterDefend = rollDice(newMonster1.getAgility());

        if (playerAttack > monsterDefend) {
            newMonster1.setDurability(newMonster1.getDurability() -1);
            System.out.println("The knight swings his sword and HITS!");
            System.out.println("Monster looses one HP");
            System.out.println("HP left: " + newMonster1.getDurability());
        } else {
            System.out.println("The knight swings his sword and MISSES!");
            System.out.println("Monster Dodges");
            System.out.println("HP left: " + newMonster1.getDurability());
        }
    }

    public static void monsterAttack() {
        double monsterAttack = rollDice(newMonster1.getAttack());
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
        } while (newMonster1.getDurability() > 0 && newPlayer.getHealth() > 0);
    }

    public static void fightingP() {
        do {
            playerAttack();
            monsterAttack();
        } while (newPlayer.getHealth() > 0 && newMonster1.getDurability() > 0);
    }

    public static boolean tryToFlee(double agility) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int randomGen;
        double chanceToFlee;
        int fleeInput;
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
    public static int rollDiceInt(int numberOfDice) {
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


        public static Monster getMonster() {
        for (int i = 0; i < GenerateMonster.monster.size(); i++) {
            if (GenerateMonster.monster.get(i) instanceof Giantspider) {
                newMonster1 = GenerateMonster.monster.get(i);
            } else if (GenerateMonster.monster.get(i) instanceof Skeleton) {
                newMonster1 = GenerateMonster.monster.get(i);
            } else if (GenerateMonster.monster.get(i) instanceof Orc) {
                newMonster1 = GenerateMonster.monster.get(i);
            } else if (GenerateMonster.monster.get(i) instanceof Troll) {
                newMonster1 = GenerateMonster.monster.get(i);
            }
        }
        return newMonster1;
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
