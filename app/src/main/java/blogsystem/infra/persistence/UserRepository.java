package blogsystem.infra.persistence;

import blogsystem.domain.post.entities.Author;
import blogsystem.domain.user.entities.User;
import blogsystem.domain.user.gateway.UserGateway;


import java.util.ArrayList; 
import java.util.List;      
import java.util.HashMap;
import java.util.Map;

public class UserRepository implements UserGateway {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findById(String userId) {
        return users.get(userId);
    }

    public Author findByAuthor(String userId) {
        User user = users.get(userId);
        if (user != null) {
            // Converte User em Author (exemplo simplificado)
            return new Author(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getNickname());
        }
        return null;
    }

    @Override
    public List<User> list() {
        return new ArrayList<>(users.values());
    }
}
