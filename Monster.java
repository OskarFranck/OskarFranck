public class Monster {


    private double initiative;
    private double durability;
    private double attack;
    private double agility;
    private double rarity;

    Monster giantSpider = new Monster (7, 1, 2, 3, 0.20);
    Monster skeleton = new Monster (4, 2, 3, 3, 0.15);
    Monster orc = new Monster (6, 3, 4, 4, 0.10);
    Monster troll = new Monster (2, 4, 7, 2, 0.05);


    public Monster(double initiative, double durability, double attack, double agility, double rarity) { //constructor
        this.initiative = initiative;
        this.durability = durability;
        this.attack = attack;
        this.agility = agility;
        this.rarity = rarity;

    }

    public double getInitiative() {
        return initiative;
    }

    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getRarity() {
        return rarity;
    }

    public void setRarity(double rarity) {
        this.rarity = rarity;
    }
}


