import java.util.Random;
public class Room {

    public static void enterRoom(){
        Random rand = new Random();
        int monsterCount;

        roomDescription();
        monsterCount = rand.nextInt(4);
        if(monsterCount == 0){
            System.out.println("No monsters in sight");
        }else{
            System.out.println("You see "+monsterCount+" monster(s) in the room");
            Fighting.fightMainBody(monsterCount);
        }
        DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).setTotalTreasure(DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getTotalTreasure()+Treasuregenerator.treasureGenerator());
        System.out.println("Total treasure so far: " + DungeonRunMain.classCharacters.get(DungeonRunMain.indexChoice).getTotalTreasure());



/*

        System.out.println("You might see a monster"); //Addera method för att generera random monster
        battlemusic();//Om monster dyker upp startar fight-klassen inkl SoundFx
        System.out.println("Vill du stanna och slåss? Eller fly!");
        System.out.println("Fight!");//Om stanna, Här startar fighten
        System.out.println("Om du överlever kan det finnas skatter i rummet!");
        Treasuregenerator.treasureGenerator();
        System.out.println("Gå ut från rummet!");

 */

    }


    public static void battlemusic(){
        String filePath = "BattleFx.wav";
        Sound music = new Sound();
        Sound.setMusic(filePath);
    }
    public static void roomDescription(){
        Random rand = new Random();
        int randomMessageInt = rand.nextInt((11)+1);
        switch(randomMessageInt){
            case 1:
                System.out.println("A short, dark corridor which leads to a room with spooky vines and an ice-cold draft which makes you shudder...");
                break;
            case 2:
                System.out.println("A horrible stench that would make anyone feel sick, hits you. This room is alleged to be haunted by the man who lived here, before committing suicide." +
                        "People says that some nights, when the moon is shining especially bright you can hear him wandering around...");
                break;
            case 3:
                System.out.println("A room with only a couple of very fragile floorboards, and mouldy walls that appear to be able to collapse at any time...walk carefully...");
                break;
            case 4:
                System.out.println("A musty smell of a room that has been abandoned for a long time fills your nose. Dusty and old furniture surrounds you, " +
                        "and a feeling of that entering the room might have been a mistake, comes to mind...");
                break;
            case 5:
                System.out.println("A room with cracked windows and mouldy, browned wooden walls with stains of blood. A dead rat lies on the floor, \n" +
                        "tho it doesn't look like it's been dead for very long...");
                break;
            case 6:
                System.out.println("The oldest residents of this room are the spiders. Cobwebs all over the place with small but intimidating spiders,\n" +
                        "like they are watching your every step...");
                break;
            case 7:
                System.out.println("The dust on the floor is thick like a carpet. A dogs bed, ripped up lie uncared for in one of the corners.\n" +
                        "Someone has left a rusty knife on a table, looks a little to perfectly placed...ready to use...");
                break;
            case 8:
                System.out.println("A fade flickering light bulb reveals a roof that could cave in any minute. The once white walls, were not so white anymore as much as stains of color on a rotting wooden wall.\n" +
                        "The floor is vibrating at times, as if something is walking or being dragged around in the room or nearby...");
                break;
            case 9:
                System.out.println("This room with its gothic architecture facade, brick interior and old painted portraits hanging on the walls is by far the oldest room on the map.\n" +
                        "The footsteps echoed on the stone floor, the stillness of the room sends shivers down the spine...");
                break;
            case 10:
                System.out.println("This room looks habitable, but by who. A round table in the middle of the room with four chairs around it, plates, cutlery...someone had prepare for dinner.\n" +
                        "The food is still in the oven, the water seeps through the tap...someone left in a hurry...");
                break;
            case 11:
                System.out.println("Sheets on furniture, ripped curtains, holes in the walls...this room is the definition of a haunted room.\n" +
                        "The temperature drops suddenly, a shiver curls through the hairs on the back of the neck running down the backbone. Something does not feel right...");
                break;
        }
    }
}
