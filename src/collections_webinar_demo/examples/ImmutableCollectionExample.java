package collections_webinar_demo.examples;
import java.util.*;

public class ImmutableCollectionExample {

    public static void run() {

        System.out.println("\n=== IMMUTABLE COLLECTION ===");

        List<Integer> numbers = List.of(1,2,3);

        System.out.println(numbers);


        numbers.add(4);

        //UnsupportedOperationException


        List<Integer> mutable = new ArrayList<>(numbers);

        mutable.add(4);

        System.out.println(mutable);

    }

}