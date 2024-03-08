package blogsystem.repositories.user.jpa.mapper;

import java.util.function.Function;

import blogsystem.domain.user.entities.User;
import blogsystem.repositories.user.jpa.model.UserJpaModel;

public class UserToUserJpaModelMapper implements Function<User, UserJpaModel>{

    public static UserJpaModel mapper(final User anUser){
        return new UserToUserJpaModelMapper().apply(anUser);
    }

    @Override
    public UserJpaModel apply(User user) {
        return new UserJpaModel(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getNickname(),
                null);
    }

}
