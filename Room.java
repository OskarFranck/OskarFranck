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


        //battlemusic();//Om monster dyker upp startar fight-klassen inkl SoundFx



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
                        " People says that some nights, when the moon is shining especially bright you can hear him wandering around...");
                break;
            case 3:
                System.out.println("A room with only a couple of very fragile floorboards, and mouldy walls that appear to be able to collapse at any time...tread carefully...");
                break;
            case 4:
                System.out.println("A musty smell of a room that has been abandoned for a long time fills your nose. Dusty and old furniture surrounds you, " +
                        "and an erie feeling of that coming here was a mistake...");
                break;
            case 5:
                System.out.println("A room with cracked windows and mouldy, browned wooden walls with stains of blood. A dead rat lies on the floor, \n" +
                        "although it doesn't look like it's been dead for very long...");
                break;
            case 6:
                System.out.println("The oldest residents of this room are the spiders. Cobwebs cover the place and you feel like you're being watched...");
                break;
            case 7://
                System.out.println("The dust on the floor is thick like a carpet and it smells foul.");
                break;
            case 8:
                System.out.println("A dying torch light reveals a roof that could cave in any minute. The once white walls, were not so white anymore.");
                break;
            case 9:
                System.out.println("This room with its gothic architecture facade, brick interior and old painted portraits hanging on the walls is by far the oldest room on the map.\n" +
                        " The footsteps echoed on the stone floor, the stillness of the room sends shivers down the your spine...");
                break;
            case 10:
                System.out.println("This room looks habitable, but by who. A round table in the middle of the room with four chairs around it, plates, cutlery...someone had prepare for dinner.\n" +
                        "The food is still in the oven, the water seeps through the tap...someone left in a hurry...");
                break;
            case 11:
                System.out.println("Sheets on furniture, ripped curtains, holes in the walls...this room is the definition of a haunted room.\n" +
                        " The temperature drops suddenly, a shiver curls through the hairs on the back of the neck running down the backbone. Something does not feel right...");
                break;
        }
    }
}
