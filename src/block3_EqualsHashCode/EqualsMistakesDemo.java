package block3_EqualsHashCode;

import utils.Printer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsMistakesDemo {

    public static void demo() {
        Printer.printHeader("БЛОК 2.5: ТИПИЧНЫЕ ОШИБКИ");

        // ОШИБКА 1: забыли hashCode
        Printer.printSubHeader("ОШИБКА 1: equals есть, hashCode нет");

        class OnlyEquals {
            String name;
            OnlyEquals(String name) { this.name = name; }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                OnlyEquals that = (OnlyEquals) o;
                return Objects.equals(name, that.name);
            }
            // hashCode не переопределён!
        }

        Set<OnlyEquals> set1 = new HashSet<>();
        set1.add(new OnlyEquals("тест"));
        set1.add(new OnlyEquals("тест"));
        System.out.println("Размер HashSet (без hashCode): " + set1.size() +
                " (должен быть 1)");

        // ОШИБКА 2: instanceof вместо getClass
        Printer.printSubHeader("ОШИБКА 2: instanceof вместо getClass");

        class Parent {
            int id;
            Parent(int id) { this.id = id; }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null) return false;
                if (!(o instanceof Parent)) return false; // ПЛОХО!
                Parent that = (Parent) o;
                return id == that.id;
            }
            @Override
            public int hashCode() { return Objects.hash(id); }
        }

        class Child extends Parent {
            String name;
            Child(int id, String name) { super(id); this.name = name; }
            // не переопределяем equals
        }

        Parent p = new Parent(1);
        Child c = new Child(1, "ребёнок");

        System.out.println("parent.equals(child): " + p.equals(c)); // true!
        System.out.println("child.equals(parent): " + c.equals(p)); // true!
        System.out.println("Проблема: объекты разных классов равны!");

        // ОШИБКА 3: изменение полей после добавления в HashSet
        Printer.printSubHeader("ОШИБКА 3: изменение полей после добавления");

        class MutableUser {
            String name;
            MutableUser(String name) { this.name = name; }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                MutableUser that = (MutableUser) o;
                return Objects.equals(name, that.name);
            }
            @Override
            public int hashCode() { return Objects.hash(name); }
        }

        Set<MutableUser> set2 = new HashSet<>();
        MutableUser user = new MutableUser("Анна");
        set2.add(user);
        System.out.println("До изменения: set содержит Анну? " +
                set2.contains(new MutableUser("Анна"))); // true

        user.name = "Мария"; // меняем поле!
        System.out.println("После изменения имени: " + user);
        System.out.println("set содержит Анну? " +
                set2.contains(new MutableUser("Анна"))); // false
        System.out.println("set содержит Марию? " +
                set2.contains(new MutableUser("Мария"))); // false
        System.out.println("Объект потерялся в HashSet!");

        Printer.printSeparator();
    }
}