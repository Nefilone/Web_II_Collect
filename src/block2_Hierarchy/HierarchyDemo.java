package block2_Hierarchy;
import utils.Printer;
import java.util.*;

public class HierarchyDemo {

    public static void demo() {
        Printer.printHeader("БЛОК 2: ИЕРАРХИЯ КОЛЛЕКЦИЙ");

        // List: порядок важен, дубликаты разрешены
        Printer.printSubHeader("LIST - упорядоченная коллекция с дубликатами");
        List<String> list = new ArrayList<>();
        list.add("Первый");
        list.add("Второй");
        list.add("Первый"); // дубликат разрешён
        list.add("Третий");
        System.out.println("ArrayList: " + list);
        System.out.println("  Размер: " + list.size());
        System.out.println("  Элемент по индексу 1: " + list.get(1));

        // Set: без дубликатов, порядок не гарантирован
        Printer.printSubHeader("SET - коллекция без дубликатов");
        Set<String> set = new HashSet<>();
        set.add("Первый");
        set.add("Второй");
        set.add("Первый"); // дубликат - будет проигнорирован
        set.add("Третий");
        System.out.println("HashSet: " + set);
        System.out.println("  Размер: " + set.size() + " (дубликат не добавился)");
        System.out.println("  Обратите внимание: порядок может отличаться от порядка добавления");

        // TreeSet - отсортированный Set
        Printer.printSubHeader("TREESET - отсортированное множество");
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Банан");
        treeSet.add("Апельсин");
        treeSet.add("Яблоко");
        treeSet.add("Апельсин"); // дубликат
        System.out.println("TreeSet (автоматически сортирует): " + treeSet);

        // Map: ключ-значение
        Printer.printSubHeader("MAP - коллекция пар ключ-значение");
        Map<String, Integer> map = new HashMap<>();
        map.put("Яблоко", 5);
        map.put("Банан", 3);
        map.put("Яблоко", 7); // перезаписывает значение по ключу
        map.put("Апельсин", 4);
        System.out.println("HashMap: " + map);
        System.out.println("  Цена яблока: " + map.get("Яблоко") + " (было 5, стало 7)");

        // LinkedList - пример множественного наследования интерфейсов
        Printer.printSubHeader("LINKEDLIST - реализует и List, и Queue");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Как List");        // метод из List
        linkedList.addFirst("В начало");    // метод из Deque
        linkedList.offer("Как Queue");      // метод из Queue
        System.out.println("LinkedList: " + linkedList);
        System.out.println("  Первый элемент: " + linkedList.getFirst());
        System.out.println("  Последний элемент: " + linkedList.getLast());

        Printer.printSeparator();
    }
}