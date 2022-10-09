import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRPGWorld {
    static String intro = """
            Наберите команду или номер этой команды:
            '[1] - trade' - идти к торговцу
            '[2] - fight' - чтобы побить монстра
            '[0] - exit' - чтобы выйти.""";

    Player player;
    Monster monster;

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
        System.out.println("goToArena");
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
                    System.out.println(intro);
                    menuItem = null;
                }

            } else {
                key = Integer.parseInt(option);
                menuItem = menuItem.values()[key];
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
