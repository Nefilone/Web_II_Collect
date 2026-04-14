package collections_webinar_demo.examples;
import collections_webinar_demo.model.UserBad;
import collections_webinar_demo.model.UserGood;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeExample {

    public static void run() {

        System.out.println("\n=== EQUALS HASHCODE ===");

        Set<UserBad> badUsers = new HashSet<>();

        badUsers.add(new UserBad("test@mail.com"));
        badUsers.add(new UserBad("test@mail.com"));

        System.out.println("Bad users size:");
        System.out.println(badUsers.size()); // будет 2


        Set<UserGood> goodUsers = new HashSet<>();

        goodUsers.add(new UserGood("test@mail.com"));
        goodUsers.add(new UserGood("test@mail.com"));

        System.out.println("Good users size:");
        System.out.println(goodUsers.size()); // будет 1

    }

}