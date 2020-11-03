public class Monster {

    private double initiative;
    private double durability;
    private double attack;
    private double agility;
    private double rarity;

    public Monster () {

    }

    public Monster(double initiative, double durability, double attack, double agility, double rarity) {
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


