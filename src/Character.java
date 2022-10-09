abstract public class Character {
    private String name;
    private int HP;
    private int strength;
    private int dexterity;
    private int exp;
    private int gold;


    public Character(String name, int HP, int strength, int dexterity, int exp, int gold) {
        this.name = name;
        this.HP = HP;
        this.strength = strength;
        this.dexterity = dexterity;
        this.exp = exp;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getExp() {
        return exp;
    }

    public int getGold() {
        return gold;
    }
}
