public class Monster extends Character{
    public Monster() {
        super(isSkeletonOrGoblin(),
                DiceRoll.roll(100),
                DiceRoll.roll(9),
                DiceRoll.roll(9),
                0,
                DiceRoll.roll(10));
    }

    private static String isSkeletonOrGoblin() {
        if ((DiceRoll.roll(100) % 2) == 0)
            return "Goblin";
        else return "Skeleton";
    }

    void rebirth (){
        this.setName(isSkeletonOrGoblin());
        this.setHP(DiceRoll.roll(100));
        this.setMaxHP(this.getHP());
        this.setStrength(DiceRoll.roll(9));
        this.setDexterity(DiceRoll.roll(9));
        this.setGold(DiceRoll.roll(9));
    }
}
