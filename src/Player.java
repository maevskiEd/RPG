public class Player extends Character implements Fighter{

    public Player(String name, int HP, int strength, int dexterity, int exp, int gold) {
        super(name, HP, strength, dexterity, exp, gold);
    }

    public Player(String name) {
        this(name, 100, 10, 10, 0, 0);
    }

    public Player(){
        this("HER");
    }

    @Override
    public void fight() {

    }
}
