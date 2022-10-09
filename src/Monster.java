public class Monster extends Character implements Fighter{
    public Monster() {
        super(isSkeletonOrGoblin(),
                getRandomValue(100),
                getRandomValue(9),
                getRandomValue(9),
                0,
                getRandomValue(10));
    }

    private static int getRandomValue(int i) {
        return (int) (Math.random() * i) + 1;
    }

    private static String isSkeletonOrGoblin() {
        if (((int) (Math.random() * 100) % 2) == 0)
            return "Goblin";
        else return "Skeleton";
    }

    @Override
    public void fight() {

    }
}
