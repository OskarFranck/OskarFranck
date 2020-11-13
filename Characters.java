public class Characters implements java.io.Serializable {

    private String name;
    private int totalTreasure;
    private int classChoice;
    private int monstersSlain;
    private int totalRuns;

    public Characters(String name, int totalTreasure, int classChoice, int monstersSlain, int totalRuns) { //constructor
        this.name = name;
        this.totalTreasure = totalTreasure;
        this.classChoice = classChoice;
        this.monstersSlain = monstersSlain;
        this.totalRuns = totalRuns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalTreasure() {
        return totalTreasure;
    }

    public void setTotalTreasure(int totalTreasure) {
        this.totalTreasure = totalTreasure;
    }

    public int getClassChoice() {
        return classChoice;
    }

    public void setClassChoice(int classChoice) {
        this.classChoice = classChoice;
    }

    public int getMonstersSlain() {
        return monstersSlain;
    }

    public void setMonstersSlain(int monstersSlain) {
        this.monstersSlain = monstersSlain;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }
}
