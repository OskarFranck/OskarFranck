public class Monster {

    private double initiative;
    private double health;
    private double attack;
    private double agility;
    private double rarity;

    public Monster () {

    }

    public Monster(double initiative, double health, double attack, double agility, double rarity) {
        this.initiative = initiative;
        this.health = health;
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
        return health;
    }

    public void setDurability(double health) {
        this.health = health;
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


