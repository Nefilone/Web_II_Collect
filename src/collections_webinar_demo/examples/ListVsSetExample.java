package collections_webinar_demo.examples;
import java.util.*;

public class ListVsSetExample {

    public static void run() {

        System.out.println("=== LIST vs SET ===");

        List<String> list = new ArrayList<>();

        list.add("Alice");
        list.add("Bob");
        list.add("Alice");

        System.out.println("List allows duplicates:");
        System.out.println(list);


        Set<String> set = new HashSet<>();

        set.add("Alice");

        System.out.println("Set removes duplicates:");
        System.out.println(set);

    }

}