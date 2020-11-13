public class SavedCharacters extends Characters {

    public SavedCharacters(String name, int totalTreasure, int classChoice, int monstersSlain, int totalRuns) {
        super(name, totalTreasure, classChoice, monstersSlain, totalRuns);

    }
    public String toString() {
        return "Name: " + getName() + "\nTotal treasure: " + getTotalTreasure() + "\nClass choice: " + getClassChoice() +"\nMonsters slain: "+getMonstersSlain()+ "\nTotal runs: "+getTotalRuns();
    }
}
