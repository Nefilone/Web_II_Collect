package block1_OOPBridge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class UserService {
    private List<User> users; // Храним как интерфейс

    public UserService() {
        // Легко меняем реализацию здесь
        //this.users = new ArrayList<>(); // было ArrayList
        this.users = new LinkedList<>(); // хотим LinkedList - просто раскомментируем

        users.add(new User("Анна"));
        users.add(new User("Иван"));
        users.add(new User("Мария"));
    }

    // ХОРОШО: возвращаем интерфейс
    public List<User> getAllUsers() {
        return users;
    }
}
