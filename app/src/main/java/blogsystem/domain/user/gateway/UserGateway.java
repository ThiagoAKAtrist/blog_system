package blogsystem.domain.user.gateway;

import blogsystem.domain.user.entities.User;
import blogsystem.domain.post.entities.Author;

import java.util.List;

public interface UserGateway {

    void save(final User user);
    User find(final String userId);
    Author findAuthor(final String userId);
    List<User> list();

}
