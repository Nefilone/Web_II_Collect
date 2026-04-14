package collections_webinar_demo.tasks;
import java.util.List;

public class StreamTaskExample {

    public static void run() {

        System.out.println("\n=== STREAM TASK ===");

        List<String> fruits =
                List.of("apple","banana","apple","orange");

        List<String> result =
                fruits.stream()
                        .distinct()
                        .sorted()
                        .toList();

        System.out.println(result);

    }

}