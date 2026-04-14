package collections_webinar_demo.model;
import java.util.Objects;

/*
 Правильная реализация equals + hashCode
*/

public class UserGood {

    private String email;

    public UserGood(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserGood user = (UserGood) o;

        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}