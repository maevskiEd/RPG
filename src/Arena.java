
public class Arena {
    Fighter fighterRed;
    Fighter fighterBlue;

    ThreadGroup tg;

    public Arena(Fighter player, Fighter monster) {
        fighterRed = player;
        fighterBlue = monster;
    }

    void fightStart() {
        Fight attackRed = new Fight(fighterRed, fighterBlue);
        Fight attackBlue = new Fight(fighterBlue, fighterRed);
        tg = new ThreadGroup("Group");
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
            attacking.fight(defensive);
            tg.interrupt();

            if (((Character) attacking).getHP() > 0) {
                if (attacking instanceof Player) {

                    ((Character) attacking).setGold(((Character) attacking).getGold()+((Character) defensive).getGold());
                    ((Character) defensive).setGold(0);
                    ((Character) attacking).setExp(((Character) defensive).getMaxHP());
                    ((Character) attacking).fullStatus();
                    ((Character) defensive).fullStatus();
                    System.out.println("Вам подвезли нового монстра.");
                    ((Monster) defensive).rebirth();
                    ((Character) defensive).fullStatus();
                    System.out.println();
                    System.out.println(ConstsClass.intro);
                } else {
                    System.out.println("Вы проиграли. Посыпьте голову пеплом и нажмите - 0");
                }

            }
        }
    }
}
