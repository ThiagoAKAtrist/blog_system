package blogsystem.repositories.user.memory;

import blogsystem.domain.user.entities.User;
import blogsystem.domain.post.entities.Author;
import blogsystem.domain.user.gateway.UserGateway;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryMemory implements UserGateway {

    private HashMap<String, User> users;

    private UserRepositoryMemory() {
        this.users = new HashMap<>();
    }

    public static UserRepositoryMemory create() {
        return new UserRepositoryMemory();
    }

    @Override
    public void save(User user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public User findById(String userId) {
        return this.users.get(userId);
    }

    @Override
    public Author findByAuthor(String author) {
        return this.users.get(author).getAuthor();
    }

    @Override
    public List<User> list() {
        return this.users.values().stream().collect(Collectors.toList());
    }
}
