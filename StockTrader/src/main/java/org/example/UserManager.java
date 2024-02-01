package org.example;
import java.util.HashMap;
import java.util.Map;

// UserManager class
class UserManager {
    private Map<String, User> users = new HashMap<>();

    public User registerUser(String username) {
        if (!users.containsKey(username)) {
            User user = new User(username);
            users.put(username, user);
            return user;
        } else {
            throw new IllegalArgumentException("Username already exists.");
        }
    }

    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "users=" + users +
                '}';
    }
}
