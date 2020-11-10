public class Monster {

    private int initiative;
    private int health;
    private int attack;
    private int agility;
    private int rarity;

    public Monster () {

    }

    public Monster(int initiative, int health, int attack, int agility, int rarity) {
        this.initiative = initiative;
        this.health = health;
        this.attack = attack;
        this.agility = agility;
        this.rarity = rarity;

    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
}


