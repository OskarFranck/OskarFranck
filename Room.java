public class Room {
    public static void enterRoom(){

        System.out.println("You enter a room"); //Addera metod som ropar på kararktären
        System.out.println("You might see a monster"); //Addera method för att generera random monster
        battlemusic();//Om monster dyker upp startar fight-klassen inkl SoundFx
        System.out.println("Vill du stanna och slåss? Eller fly!");
        System.out.println("Fight!");//Om stanna, Här startar fighten
        System.out.println("Om du överlever kan det finnas skatter i rummet!");
        Treasuregenerator.treasureGenerator();
        System.out.println("Gå ut från rummet!");

    }

    public static void battlemusic(){
        String filePath = "BattleFx.wav";
        Sound music = new Sound();
        Sound.setMusic(filePath);
    }
}
