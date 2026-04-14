package block3_EqualsHashCode;
import java.util.Objects;

public class UserBad {
    public String name;
    public int age;

    public UserBad(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBad userBad = (UserBad) o;
        return age == userBad.age && Objects.equals(name, userBad.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // equals и hashCode НЕ переопределены - будет использоваться реализация из Object
}