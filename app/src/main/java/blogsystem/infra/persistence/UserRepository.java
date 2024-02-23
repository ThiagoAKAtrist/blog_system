package blogsystem.infra.persistence;

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
    public User find(String userId) {
        return users.get(userId);
    }

    @Override
    public List<User> list() {
        return new ArrayList<>(users.values());
    }
}
