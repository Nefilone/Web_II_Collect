package block5_Sorting;
import utils.Printer;
import java.util.*;

public class SortingDemo {

    public static void demo() {
        Printer.printHeader("БЛОК 5: СОРТИРОВКА (Comparable vs Comparator)");

        // Подготовка данных
        List<Person> people = new ArrayList<>();
        people.add(new Person("Анна", 25));
        people.add(new Person("Иван", 30));
        people.add(new Person("Мария", 20));
        people.add(new Person("Петр", 25));
        people.add(new Person("Елена", 28));

        System.out.println("Исходный список:");
        people.forEach(p -> System.out.println("  " + p));

        // 1. Естественная сортировка (Comparable - по возрасту)
        Printer.printSubHeader("1. ЕСТЕСТВЕННАЯ СОРТИРОВКА (Comparable - по возрасту)");
        List<Person> peopleForSort1 = new ArrayList<>(people);
        Collections.sort(peopleForSort1);
        System.out.println("После Collections.sort():");
        peopleForSort1.forEach(p -> System.out.println("  " + p));

        // 2. Сортировка по имени через Comparator (анонимный класс)
        Printer.printSubHeader("2. СОРТИРОВКА ПО ИМЕНИ (Comparator, анонимный класс)");
        List<Person> peopleForSort2 = new ArrayList<>(people);

        Comparator<Person> byName = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };

        Collections.sort(peopleForSort2, byName);
        System.out.println("После сортировки по имени:");
        peopleForSort2.forEach(p -> System.out.println("  " + p));

        // 3. Сортировка через лямбда (по убыванию возраста)
        Printer.printSubHeader("3. СОРТИРОВКА ПО УБЫВАНИЮ ВОЗРАСТА (лямбда)");
        List<Person> peopleForSort3 = new ArrayList<>(people);
        peopleForSort3.sort((p1, p2) -> p2.getAge() - p1.getAge()); // по убыванию
        System.out.println("После сортировки по убыванию возраста:");
        peopleForSort3.forEach(p -> System.out.println("  " + p));

        // 4. Современный способ: Comparator.comparing()
        Printer.printSubHeader("4. СОРТИРОВКА Comparator.comparing()");
        List<Person> peopleForSort4 = new ArrayList<>(people);
        peopleForSort4.sort(Comparator.comparing(Person::getName));
        System.out.println("По имени (method reference):");
        peopleForSort4.forEach(p -> System.out.println("  " + p));

        // 5. Цепочка компараторов
        Printer.printSubHeader("5. ЦЕПОЧКА КОМПАРАТОРОВ: сначала по возрасту, потом по имени");
        List<Person> peopleForSort5 = new ArrayList<>(people);
        peopleForSort5.sort(
                Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName)
        );
        System.out.println("Результат (сначала возраст, потом имя):");
        peopleForSort5.forEach(p -> System.out.println("  " + p));

        // 6. Обратный порядок
        Printer.printSubHeader("6. ОБРАТНЫЙ ПОРЯДОК (reversed)");
        List<Person> peopleForSort6 = new ArrayList<>(people);
        peopleForSort6.sort(Comparator.comparing(Person::getAge).reversed());
        System.out.println("По убыванию возраста (reversed):");
        peopleForSort6.forEach(p -> System.out.println("  " + p));

        // Сравнение производительности разных подходов
        Printer.printSubHeader("ИТОГ: КОГДА ЧТО ИСПОЛЬЗОВАТЬ?");
        System.out.println("  • Comparable - если есть 'естественный' порядок (по умолчанию)");
        System.out.println("  • Comparator - если нужно много разных способов сортировки");
        System.out.println("  • Лямбды - для простых компараторов");
        System.out.println("  • Comparator.comparing() - современный и читаемый подход");

        Printer.printSeparator();
    }
}