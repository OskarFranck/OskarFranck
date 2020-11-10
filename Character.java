public abstract class Character {

    private int initiative;
    private int health;
    private int attack;
    private int agility;

    public Character() {

    }

    public Character(int initiative, int health, int attack, int agility) {
        this.initiative = initiative;
        this.health = health;
        this.attack = attack;
        this.agility = agility;
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

    public abstract void specialAbility();
}
