package block4_ConcurrentMod;
import utils.Printer;
import java.util.*;

public class ConcurrentModDemo {

    public static void demo() {
        Printer.printHeader("БЛОК 4: ConcurrentModificationException");

        // ОШИБКА: удаление в for-each
        Printer.printSubHeader("ОШИБКА: удаление в for-each");
        List<String> list = new ArrayList<>(List.of("A", "B", "C", "B", "D", "E"));
        System.out.println("Исходный список: " + list);

        try {
            // Этот код вызовет исключение
            for (String item : list) {
                if (item.equals("B")) {
                    System.out.println("  Пытаемся удалить '" + item + "'...");
                    //list.remove(item); // РАСКОММЕНТИРУЙТЕ для демонстрации ошибки
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("  ✗ ConcurrentModificationException! Нельзя удалять в for-each");
        }
        // Закомментировано, чтобы программа не падала
        System.out.println("  ✓ Код закомментирован, чтобы избежать ошибки");
        System.out.println("  ✗ Если раскомментировать - получим исключение");

        // ПРАВИЛЬНО 1: через Iterator
        Printer.printSubHeader("ПРАВИЛЬНО 1: удаление через Iterator");
        List<String> list2 = new ArrayList<>(List.of("A", "B", "C", "B", "D", "E"));
        System.out.println("До удаления: " + list2);

        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("B")) {
                iterator.remove(); // Безопасное удаление
                System.out.println("  Удалили: " + item);
            }
        }
        System.out.println("После iterator.remove(): " + list2);

        // ПРАВИЛЬНО 2: removeIf (Java 8+)
        Printer.printSubHeader("ПРАВИЛЬНО 2: removeIf (современный способ)");
        List<String> list3 = new ArrayList<>(List.of("A", "B", "C", "B", "D", "E"));
        System.out.println("До removeIf: " + list3);

        list3.removeIf(item -> item.equals("B"));
        System.out.println("После removeIf: " + list3);

        // ПРАВИЛЬНО 3: копия коллекции
        Printer.printSubHeader("ПРАВИЛЬНО 3: итерация по копии");
        List<String> list4 = new ArrayList<>(List.of("A", "B", "C", "B", "D", "E"));
        System.out.println("До удаления: " + list4);

        List<String> copy = new ArrayList<>(list4); // создаём копию
        for (String item : copy) {
            if (item.equals("B")) {
                list4.remove(item); // удаляем из оригинальной
                System.out.println("  Удалили: " + item);
            }
        }
        System.out.println("После удаления по копии: " + list4);

        // Дополнительно: что будет, если изменять во время итерации, но не удалять?
        Printer.printSubHeader("ВАЖНО: изменение элементов БЕЗ изменения структуры");
        List<String> list5 = new ArrayList<>(List.of("A", "B", "C"));
        System.out.println("До изменения: " + list5);

        for (int i = 0; i < list5.size(); i++) {
            list5.set(i, list5.get(i) + "!"); // изменяем элементы - это безопасно
        }
        System.out.println("После изменения элементов: " + list5);
        System.out.println("  Изменять элементы можно, менять структуру - нет");

        Printer.printSeparator();
    }
}