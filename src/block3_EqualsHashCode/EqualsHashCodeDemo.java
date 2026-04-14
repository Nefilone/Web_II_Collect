package block3_EqualsHashCode;
import utils.Printer;
import java.util.*;

public class EqualsHashCodeDemo {

    public static void demo() {
        Printer.printHeader("БЛОК 3: equals() И hashCode()");

        // Демонстрация проблемы с классом без equals/hashCode
        Printer.printSubHeader("КЛАСС БЕЗ equals/hashCode (UserBad)");
        Set<UserBad> badSet = new HashSet<>();

        UserBad user1 = new UserBad("Alice", 25);
        UserBad user2 = new UserBad("Alice", 25); // Логически тот же пользователь

        badSet.add(user1);
        badSet.add(user2);

        System.out.println("Создали двух пользователей с одинаковыми данными");
        System.out.println("user1 == user2? " + (user1 == user2)); // false
        System.out.println("user1.equals(user2)? " + user1.equals(user2)); // false (без переопределения)
        System.out.println("Размер Set: " + badSet.size()); // 2! Дубликат

        // Демонстрация правильной реализации
        Printer.printSubHeader("КЛАСС С equals/hashCode (UserGood)");
        Set<UserGood> goodSet = new HashSet<>();

        UserGood userGood1 = new UserGood("Bob", 30);
        UserGood userGood2 = new UserGood("Bob", 30); // Логически тот же пользователь

        goodSet.add(userGood1);
        goodSet.add(userGood2);

        System.out.println("userGood1.equals(userGood2)? " + userGood1.equals(userGood2)); // true
        System.out.println("userGood1.hashCode(): " + userGood1.hashCode());
        System.out.println("userGood2.hashCode(): " + userGood2.hashCode());
        System.out.println("Размер Set: " + goodSet.size()); // 1! Один объект

        // Демонстрация поиска в HashMap
        Printer.printSubHeader("ПОИСК В HASHMAP");
        Map<UserGood, String> goodMap = new HashMap<>();
        UserGood key = new UserGood("Charlie", 35);
        goodMap.put(key, "Информация о Charlie");

        UserGood searchKey = new UserGood("Charlie", 35);
        String result = goodMap.get(searchKey);
        System.out.println("Найден ли Charlie? " + (result != null ? "Да: " + result : "Нет"));

        // ОШИБКА: если бы использовали UserBad, не нашли бы
        Map<UserBad, String> badMap = new HashMap<>();
        UserBad badKey = new UserBad("David", 40);
        badMap.put(badKey, "Информация о David");

        UserBad badSearchKey = new UserBad("David", 40);
        String badResult = badMap.get(badSearchKey);
        System.out.println("Найден ли David в badMap? " + (badResult != null ? "Да" : "Нет (не нашли!)"));

        // Объяснение важности контракта
        Printer.printSubHeader("ВАЖНО: КОНТРАКТ equals И hashCode");
        System.out.println("  Если объекты равны по equals(), их hashCode должен быть одинаковым");
        System.out.println("  У UserGood это выполняется: " + userGood1.hashCode() + " = " + userGood2.hashCode());
        System.out.println("  У UserBad hashCode случайный: " + user1.hashCode() + " vs " + user2.hashCode());

        Printer.printSeparator();
    }
}