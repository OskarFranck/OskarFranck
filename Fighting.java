import java.util.*;

public class Fighting extends GenerateMonster{

    /*
    static Monster giantSpider = new Giantspider (7, 1, 2, 3);
    static Monster skeleton = new Skeleton (4, 2, 3, 3);
    static Monster orc = new Orc (6, 3, 4, 4);
    static Monster troll = new Troll (2, 4, 7, 2);
    */

    static Classes newPlayer = null;
    static ArrayList<Integer> orderForFight = new ArrayList<>();

    /*
    1. riddare
    2. trollkarl
    3. tjuv
    */

    public static void fightMainBody(int monsterCount){

        for (int i = 0; i < monsterCount; i++) {
           // getPlayer();

           // getMonster();
            whoStartsFight(getPlayer(), getMonster());
        }
    }


    public static double[] getPlayer() {
        double[] player = new double[4]; //Nuvarande värde på antalet info som slussas vidare med player
        //Int               = 0
        //Atk               = 1
        //Agi               = 2
        //Hp                = 3
        //Treasure          = 4?
        //Monsters slain    = 5?

        //if (DungeonRunMain.classCharacters.)

            if (DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice() == 0) {
                player[0] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getInitiative();
                player[1] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getAttack();
                player[2] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getAgility();
                player[3] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getHealth();

            } else if (DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice() == 1) {
                player[0] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getInitiative();
                player[1] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getAttack();
                player[2] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getAgility();
                player[3] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getHealth();

            } else if (DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice() == 2) {
                player[0] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getInitiative();
                player[1] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getAttack();
                player[2] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getAgility();
                player[3] = DungeonRunMain.classesList.get(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getClassChoice()).getHealth();
            }

        return player;
    }

    public static double[] getMonster() {
        GenerateMonster.monster.clear();
        monster = GenerateMonster.randomMonster();
        double[] monster = new double[4];//Plockar antal värden från monster
        //Int               = 0
        //Atk               = 1
        //Agi               = 2
        //Hp                = 3

        for (int i = 0; i < GenerateMonster.monster.size(); i++) {
            if (GenerateMonster.monster.get(i) instanceof Giantspider) {
                monster[0] = GenerateMonster.monster.get(i).getInitiative();
                monster[1] = GenerateMonster.monster.get(i).getAttack();
                monster[2] = GenerateMonster.monster.get(i).getAgility();
                monster[3] = GenerateMonster.monster.get(i).getDurability();

            } else if (GenerateMonster.monster.get(i) instanceof Skeleton) {
                monster[0] = GenerateMonster.monster.get(i).getInitiative();
                monster[1] = GenerateMonster.monster.get(i).getAttack();
                monster[2] = GenerateMonster.monster.get(i).getAgility();
                monster[3] = GenerateMonster.monster.get(i).getDurability();

            } else if (GenerateMonster.monster.get(i) instanceof Orc) {
                monster[0] = GenerateMonster.monster.get(i).getInitiative();
                monster[1] = GenerateMonster.monster.get(i).getAttack();
                monster[2] = GenerateMonster.monster.get(i).getAgility();
                monster[3] = GenerateMonster.monster.get(i).getDurability();

            } else if (GenerateMonster.monster.get(i) instanceof Troll) {
                monster[0] = GenerateMonster.monster.get(i).getInitiative();
                monster[1] = GenerateMonster.monster.get(i).getAttack();
                monster[2] = GenerateMonster.monster.get(i).getAgility();
                monster[3] = GenerateMonster.monster.get(i).getDurability();
            }
        }

        return monster;
    }

    public static void whoStartsFight(double[] player, double[] monster) {
        double playerIni = rollDice(player[0]);
        double monsterIni = rollDice(monster[0]);

        if (playerIni < monsterIni) {
            System.out.println("Monster is faster");
            fightingM(player, monster);
        } else if (playerIni > monsterIni) {
            System.out.println("Player is faster");
            fightingP(player, monster);
        }
    }

    public static void playerAttack(double[] player, double[] monster) {
        double playerAttack = rollDice(player[1]);
        double monsterDefend = rollDice(monster[2]);

        if (playerAttack > monsterDefend) {
            monster[3] = monster[3] - 1;
            System.out.println("The player swings his sword and HITS!");
            System.out.println("Monster loses one HP");
            System.out.println("HP left: " + monster[3]);
        } else {
            System.out.println("The player swings his sword and MISSES!");
            System.out.println("Monster Dodges");
            System.out.println("HP left: " + monster[3]);
        }
    }

    public static void monsterAttack(double[] player, double[] monster) {
        double monsterAttack = rollDice(monster[1]);
        double playerDefend = rollDice(player[2]);

        if (monsterAttack > playerDefend) {
            player[3] = player[3] - 1;
            System.out.println("Player loses one HP");
            System.out.println("HP left: " + player[3]);
        } else {
            System.out.println("Player dodges");
            System.out.println("HP left: " + player[3]);
        }
    }
    public static void fightingM(double[] player, double[] monster) {
        while (monster[3] > 0 && player[3] > 0 && tryToFlee(player[2])) {
            monsterAttack(player, monster);
            playerAttack(player, monster);
        }
    }

    public static void fightingP(double[] player, double[] monster) {
        while (monster[3] > 0 && player[3] > 0 && tryToFlee(player[2])) {
            playerAttack(player, monster);
            monsterAttack(player, monster);
        }
    }

    public static boolean tryToFlee(double agility) {
        boolean loopIsRunning = true;
        Random rand = new Random();
        int randomGen;
        double chanceToFlee;
        int fleeInput;
        randomGen = rand.nextInt(99) + 1;
        chanceToFlee = agility * 10;

        while(loopIsRunning){

            System.out.println("The fear is running through your vain\n [1]. Fight [2]. Flee");

            fleeInput = DungeonRunMain.intInputMethod();
            if(fleeInput != 2){
                break;
            }else{
                switch (fleeInput) {
                    case 2:
                        if (randomGen <= chanceToFlee) {
                            return false;
                        } else {
                            return true;
                        }
                    //default:
                    //    return true;
                }
            }
        }
        return true;
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

/*
EMPLOYEE STATISTIC

import java.util.ArrayList;
import java.util.Collections;

public class EmpStat extends EmpManage{
    static ArrayList<Integer> salary = new ArrayList<>();
    static ArrayList<String> female = new ArrayList<>();
    static ArrayList<String> male = new ArrayList<>();

    //Metoden som kollar % på företagens könsuppdelning
    public static void genderPercentage() {
        male.clear();
        female.clear();
        for (int i = 0; i < employees.size(); i++) {
            if ("male".equals(employees.get(i).getGender().toLowerCase())) {
                male.add(employees.get(i).getGender());
            } else {
                female.add(employees.get(i).getGender());
            }
        }
        double mS = male.size();
        double fS = female.size();
        double eS = employees.size();
        System.out.println("Male percentage: \t" + (mS/eS)*100 + " %");
        System.out.println("Female percentage: \t" + (fS/eS)*100 + " %");
        MenuList.menuStats();
    }
}
*/