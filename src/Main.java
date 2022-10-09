import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("New Game - start.Введите имя персонажа:");
        String s = scanner.nextLine();
        MyRPGWorld rpgWorld = new MyRPGWorld(s);
        System.out.println("Здравствуйте. Спасибо, что зашли в эту бессмысленную игру:");
        System.out.println("Ваше имя: " + rpgWorld.player.getName());
        System.out.printf("Ваши характеристики: HP %d, str %d, dex %d%n",
                rpgWorld.player.getHP(), rpgWorld.player.getStrength(), rpgWorld.player.getDexterity());
        System.out.printf("У вас совсем нет денег и опыта: gold = %d, exp = %d%n",
                rpgWorld.player.getGold(), rpgWorld.player.getExp());


        System.out.printf("""
                        Перед вами стоит монстр: %s
                        с характеристиками: HP %d, str %d, dex %d
                        Наберите команду или номер этой команды:
                        '[1] - trade' - идти к торговцу
                        '[2] - fight' - чтобы побить монстра
                        '[0] - exit' - чтобы выйти.""",
                rpgWorld.monster.getName(),
                rpgWorld.monster.getHP(),
                rpgWorld.monster.getStrength(),
                rpgWorld.monster.getDexterity());
        System.out.println();

        while (true) {
            s = scanner.nextLine();
            if (s.equalsIgnoreCase("exit") || s.equals("0")) break;
            else rpgWorld.choiceMenu(s);
        }
    }
}
