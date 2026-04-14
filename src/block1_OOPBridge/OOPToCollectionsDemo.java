package block1_OOPBridge;
import utils.Printer;
import java.util.*;

public class OOPToCollectionsDemo {

    public static void demo() {
        Printer.printHeader("БЛОК 1: МОСТИК ОТ ООП К КОЛЛЕКЦИЯМ");

        // ПЛОХО: привязка к конкретной реализации
        Printer.printSubHeader("ПЛОХОЙ ПОДХОД: привязка к конкретной реализации");
        LinkedList<String> badList = new LinkedList<>();
        badList.add("Привязались к ArrayList");
        badList.add("Если захотим LinkedList - придётся переписывать код");
        System.out.println("badList: " + badList);

        // ХОРОШО: программируем на уровне интерфейса
        Printer.printSubHeader("ХОРОШИЙ ПОДХОД: программируем на уровне интерфейса List");
        List<String> goodList = new ArrayList<>(); // легко меняем на LinkedList
        goodList.add("Работаем через интерфейс");
        goodList.add("Можно легко заменить реализацию");
        System.out.println("goodList: " + goodList);

        // Демонстрация полиморфизма
        Printer.printSubHeader("ПОЛИМОРФИЗМ: метод принимает List, работает с любыми реализациями");
        List<String> arrayList = new ArrayList<>(List.of("A", "B", "C"));
        List<String> linkedList = new LinkedList<>(List.of("X", "Y", "Z"));

        processItems(arrayList);
        processItems(linkedList); // тот же метод работает с другой реализацией!

        Printer.printSeparator();
    }

    // Метод принимает интерфейс List, а не конкретную реализацию
    public static void processItems(List<String> items) {
        System.out.println("  Обрабатываем список типа: " + items.getClass().getSimpleName() +
                ", размер: " + items.size());
    }
}