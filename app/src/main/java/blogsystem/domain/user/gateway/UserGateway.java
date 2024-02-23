package blogsystem.domain.user.gateway;

import blogsystem.domain.user.entities.User;

import java.util.List;

public interface UserGateway {

    void save(final User user);
    User find(final String userId);
    List<User> list();

}
