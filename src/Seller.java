public interface Seller {
    default void buy() {
        System.out.println("Покупаем");
    }

    default void sell() {
        System.out.println("Продаем");
    }
}
