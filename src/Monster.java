public class Monster extends Character  implements Fighter, DiceRoll{
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

    public void fight(Fighter opponent) {
        System.out.printf("Я бьюсь головой об стену. %s Противник %s смотрит и смеется.%n",
                this.getName(),((Character) opponent).getName());

    }
}
