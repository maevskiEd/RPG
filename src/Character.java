abstract public class Character implements Fighter, DiceRoll {
    private String name;
    private int HP;
    private int strength;
    private int dexterity;
    private int exp;
    private int gold;
    private int maxHP;


    public Character(String name, int HP, int strength, int dexterity, int exp, int gold) {
        this.name = name;
        this.HP = HP;
        this.strength = strength;
        this.dexterity = dexterity;
        this.exp = exp;
        this.gold = gold;
        this.maxHP = HP;
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

    public int getMaxHP() {
        return maxHP;
    }

    public void setHP(int HP) {
        if (HP < 0) HP = 0;
        this.HP = HP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void status() {
        System.out.printf("%s HP: %d%n", this.getName(), this.getHP());
    }

    public void fullStatus() {
        System.out.printf("%s HP: %d, str: %d, dex: %d, Exp: %d, Gold: %d%n",
                this.getName(), this.getHP(), this.getStrength(), this.getDexterity(), this.getExp(), this.getGold());
    }

    public void fight(Fighter opponent) {
        boolean isInterrupted = true;
        int randStrength;
//        int criticalHP = (int) (0.2 * this.getHP());

        while (this.getHP() > 0 && ((Character) opponent).getHP() != 0 && isInterrupted) {
            if (3 * this.getDexterity() > DiceRoll.roll(100)) {
                randStrength = DiceRoll.roll(this.getStrength());
                ((Character) opponent).setHP(((Character) opponent).getHP() - randStrength);
                System.out.printf("%s ударил с силой - %s%n", this.getName(), randStrength);
                System.out.printf("У противника осталось жизни: ");
                ((Character) opponent).status();
            } else {
                System.out.printf("%s ударил и промахнулся%n", this.getName());
            }


            try {
                Thread.sleep(DiceRoll.roll(1000));
            } catch (InterruptedException e) {
//                System.out.println("Один из потоков завершен.");
                isInterrupted = false;
            }

        }
    }

}
