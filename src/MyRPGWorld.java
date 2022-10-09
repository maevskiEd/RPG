import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRPGWorld {
    Player player;
    Monster monster;

    Arena arena;

    private Menu menu = new Menu();

    public MyRPGWorld(String name) {
        if (name == null) player = new Player();
        else player = new Player(name);
        monster = new Monster();
    }

    public void choiceMenu(String command) {
        if (command != null) {
            menu.checkAndDo(command.toUpperCase());
        }
    }

    private void goToArena(Player player, Monster monster) {
        arena = new Arena(player, monster);
        arena.fightStart();
    }

    private void trade() {
        System.out.println("Ушел на базу. Буду скоро.");
    }

    class Menu {
        enum MenuItem {EXIT, TRADE, FIGHT}

        MenuItem menuItem;

        void checkAndDo(String option) {
            int key = 0;
            Pattern p = Pattern.compile("^[0-2]");
            Matcher m = p.matcher(option);
            if (!m.find()) {
                try {
                    menuItem = MenuItem.valueOf(option);
                    key = menuItem.ordinal();
                } catch (Exception e) {
                    System.out.println("Вводите команды согласно инструкции.");
                    System.out.println(ConstsClass.intro);
                    menuItem = null;
                }

            } else {
                key = Integer.parseInt(option);
                menuItem = MenuItem.values()[key];
            }

            if (menuItem != null) {
                switch (key) {
                    case 1:
                        trade();
                        break;
                    case 2:
                        goToArena(player, monster);
                        break;
                    default:
                        System.out.println("default");
                }
            }
        }
    }
}
