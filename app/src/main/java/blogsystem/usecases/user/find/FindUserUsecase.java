package blogsystem.usecases.user.find;

import blogsystem.domain.user.entities.User;
import blogsystem.domain.user.gateway.UserGateway;
import blogsystem.usecases.Usecase;
import blogsystem.usecases.exceptions.NotFoundException;

public class FindUserUsecase implements Usecase<FindUserInputDto, FindUserOutputDto> {

    private final UserGateway userGateway;

    private FindUserUsecase(final UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public static FindUserUsecase create(final UserGateway userGateway) {
        return new FindUserUsecase(userGateway);
    }

    @Override
    public FindUserOutputDto execute(final FindUserInputDto input) {
        User foundUser = userGateway.find(input.userId());

        if (foundUser == null) {
            throw new NotFoundException("User not found");
        }

        return new FindUserOutputDto(
                foundUser.getId(),
                foundUser.getName(),
                foundUser.getEmail(),
                foundUser.getNickname()
        );
    }
}
