import java.util.*;

public class Fighting extends GenerateMonster{

    public static void fightMainBody(int monsterCount){

        for (int i = 0; i < monsterCount; i++) {
            whoStartsFight(getPlayer(), getMonster());
        }
        win();
    }


    public static double[] getPlayer() {
        double[] player = new double[4]; //Nuvarande värde på antalet info som slussas vidare med player
        //Int               = 0
        //Atk               = 1
        //Agi               = 2
        //Hp                = 3
        //Treasure          = 4?
        //Monsters slain    = 5?

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
            System.out.println("Monster is faster and attack first");
            fightingM(player, monster);
        } else if (playerIni > monsterIni) {
            System.out.println("Player is faster and attack first");
            fightingP(player, monster);
        }
    }

    public static void playerAttack(double[] player, double[] monster) {
        double playerAttack = rollDice(player[1]);
        double monsterDefend = rollDice(monster[2]);

        if (playerAttack > monsterDefend) {
            monster[3] = monster[3] - 1;
            System.out.println("The player swings his sword and HITS!\nMonster loses one HP\nHP left: "+ monster[3]);
            soundHit1();
            if (monster[3] <= 0) {
                System.out.println("The beast falls dead to the ground");
                mobDead();
            }
        } else {
            System.out.println("The player swings his sword and MISSES!\nMonster Dodges\nHP left: "+ monster[3]);
            soundHit2();
        }
    }

    public static void monsterAttack(double[] player, double[] monster) {
        double monsterAttack = rollDice(monster[1]);
        double playerDefend = rollDice(player[2]);

        if (monsterAttack > playerDefend) {
            player[3] = player[3] - 1;
            System.out.println("The monster swings his club at you and HITS!\nPlayer loses one HP\nHP left: " + player[3]);
            soundHit2();
            if (player[3] == 1) {
                System.out.println("You've lost a lot of blood and will soon perish");
            } else if (player[3] <= 0) {
                System.out.println("You are DEAD!\nGame Over!");
                dead();
                DungeonRunMain.exit();
            }
        } else {
            System.out.println("The monster swings his club at you and MISSES!\nPlayer dodges\nHP left: " + player[3]);
        }
    }
    public static void fightingM(double[] player, double[] monster) {
        while (monster[3] > 0 && player[3] > 0 && tryToFlee(player[2])) {

            if (monster[3] <= 0 || player[3] <= 0) {
                break;
            }
            monsterAttack(player, monster);
            playerAttack(player, monster);
        }
    }

    public static void fightingP(double[] player, double[] monster) {
        while (monster[3] > 0 && player[3] > 0 && tryToFlee(player[2])) {

            if (monster[3] <= 0 || player[3] <= 0) {
                break;
            }
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

            System.out.println("The fear is running through your veins [1].Fight or try to [2].Flee");

            fleeInput = DungeonRunMain.intInputMethod();
            if(fleeInput != 2){
                break;
            }else{
                switch (fleeInput) {
                    case 2:
                        if (randomGen <= chanceToFlee) {
                            System.out.println("You manage to escaped...");
                            win();
                            return false;
                        } else {
                            System.out.println("You can't run, stay and fight you coward!");
                            soundHit2();
                            return true;
                        }
                }
            }
        }
        System.out.println("We stand our ground and fight!");
        return true;
    }
    public static void battleMusic(){
        String filePath = "BattleFx.wav";
        Sound music = new Sound();
        Sound.setMusic(filePath);
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

    public static void soundHit1(){
        String filePath = "hit.wav";   //kod som kallar på slag
        Sound hit = new Sound();
        Sound.setFx(filePath);
        enter();
    }

    public static void soundHit2(){
        String filePath = "danger.wav";   //kod som kallar på slag
        Sound hit = new Sound();
        Sound.setFx(filePath);
        enter();

    }

    public static void mobDead(){
        String filePath = "RaspyHit.wav";
        Sound mobDead = new Sound();
        Sound.setFx(filePath);
        enter();
    }

    public static void dead(){
        String filePath = "dead.wav";
        Sound dead = new Sound();
        Sound.setFx(filePath);
    }

    public static void win(){
        String filePath = "powerUp.wav";
        Sound win = new Sound();
        Sound.setFx(filePath);
        enter();
    }

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

    public static void enter(){
        System.out.println("Click [ENTER] to continue... ");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}