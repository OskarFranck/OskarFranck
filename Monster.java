public class Monster {


    private double initiative;
    private double health;
    private double attack;
    private double agility;

    public Monster(double initiative, double health, double attack, double agility) { //constructor

        this.initiative = initiative;
        this.health = health;
        this.attack = attack;
        this.agility = agility;


    }

    public Monster() {

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

}


