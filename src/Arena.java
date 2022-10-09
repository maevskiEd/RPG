
public class Arena {
    Fighter fighterRed;
    Fighter fighterBlue;

    public Arena(Fighter player, Fighter monster) {
        fighterRed = player;
        fighterBlue = monster;
    }

    void fightStart() {
        Fight attackRed = new Fight(fighterRed, fighterBlue);
        Fight attackBlue = new Fight(fighterBlue, fighterRed);
        ThreadGroup tg = new ThreadGroup("Group");
        Thread threadRed = new Thread(tg, attackRed);
        Thread threadBlue = new Thread(tg, attackBlue);

        threadRed.start();
        threadBlue.start();
    }

    class Fight implements Runnable {
        Fighter attacking;
        Fighter defensive;

        public Fight(Fighter attacking, Fighter defensive) {
            this.attacking = attacking;
            this.defensive = defensive;
        }

        @Override
        public void run() {
            System.out.printf("Attacking: %s, Defensive: %s%n",
                    ((Character) attacking).getName(),((Character) defensive).getName());
            attacking.fight(defensive);
        }
    }
}
