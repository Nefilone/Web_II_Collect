package collections_webinar_demo.examples;
import java.util.*;

public class ConcurrentModificationExample {

    public static void run() {

        System.out.println("\n=== CONCURRENT MODIFICATION ===");

        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        /*
        НЕЛЬЗЯ ТАК ДЕЛАТЬ

        for (String s : list) {

            if (s.equals("B")) {

                list.remove(s); // ConcurrentModificationException

            }

        }
        */


        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {

            String s = iterator.next();

            if (s.equals("B")) {

                iterator.remove();

            }

        }

        System.out.println(list);

    }

}