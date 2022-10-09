public interface DiceRoll {
    static int roll(int i) {
        return (int) (Math.random() * i) + 1;
    }
}
