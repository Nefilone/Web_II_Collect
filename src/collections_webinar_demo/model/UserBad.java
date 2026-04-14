package collections_webinar_demo.model;
/*
 Класс без equals/hashCode
 Используется чтобы показать проблему с HashSet
*/

public class UserBad {

    private String email;

    public UserBad(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}