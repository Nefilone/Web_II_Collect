package block1_OOPBridge;

import utils.Printer;
import java.util.*;

public class TimeComplexityDemo {

    public static void demo() {
        Printer.printHeader("ДЕМОНСТРАЦИЯ ВРЕМЕННОЙ СЛОЖНОСТИ");

        // Подготовка данных
        int size = 100_000;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();

        // Заполняем коллекции
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
            hashSet.add(i);
        }

        // 1. Демонстрация get(index) - ArrayList быстр, LinkedList медленен
        Printer.printSubHeader("get(index) — ДОСТУП ПО ИНДЕКСУ");

        long start = System.nanoTime();
        int value1 = arrayList.get(size / 2); // берём элемент из середины
        long time1 = System.nanoTime() - start;
        System.out.println("ArrayList.get(): " + time1 + " нс — O(1)");

        start = System.nanoTime();
        int value2 = linkedList.get(size / 2);
        long time2 = System.nanoTime() - start;
        System.out.println("LinkedList.get(): " + time2 + " нс — O(n)");
        System.out.println("  (в " + (time2 / time1) + " раз медленнее)");

        // 2. Демонстрация contains - HashSet быстр, ArrayList медленен
        Printer.printSubHeader("contains(element) — ПОИСК ЭЛЕМЕНТА");

        start = System.nanoTime();
        boolean found1 = arrayList.contains(size - 1); // ищем последний элемент
        time1 = System.nanoTime() - start;
        System.out.println("ArrayList.contains(): " + time1 + " нс — O(n)");

        start = System.nanoTime();
        boolean found2 = hashSet.contains(size - 1);
        time2 = System.nanoTime() - start;
        System.out.println("HashSet.contains(): " + time2 + " нс — O(1)");
        System.out.println("  (HashSet в " + (time1 / time2) + " раз быстрее)");

        // 3. Демонстрация add в середину
        Printer.printSubHeader("add(index) — ВСТАВКА В СЕРЕДИНУ");

        start = System.nanoTime();
        arrayList.add(size / 2, -1); // вставляем в середину
        time1 = System.nanoTime() - start;
        System.out.println("ArrayList.add(середина): " + time1 + " нс — нужно сдвигать элементы");

        start = System.nanoTime();
        linkedList.add(size / 2, -1); // вставляем в середину
        time2 = System.nanoTime() - start;
        System.out.println("LinkedList.add(середина): " + time2 + " нс — просто меняем ссылки");

        Printer.printSeparator();
    }
}
