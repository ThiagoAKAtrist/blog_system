package blogsystem.usecases.user.add;

import java.util.UUID;

import blogsystem.domain.user.entities.User;
import blogsystem.domain.user.gateway.UserGateway;
import blogsystem.usecases.Usecase;

public class AddUserUsecase implements Usecase<AddUserInputDto, AddUserOutputDto> {

    private final UserGateway userGateway;

    private AddUserUsecase(final UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public static AddUserUsecase create(final UserGateway userGateway) {
        return new AddUserUsecase(userGateway);
    }

    @Override
    public AddUserOutputDto execute(final AddUserInputDto input) {

        // Criação de acordo com as regras de domínio
        final User newUser = User.create(
                null,
                input.aName(),
                input.anEmail(),
                input.aPassword(),
                input.aNickname());

        // Persiste no banco de dados utilizando o gateway
        this.userGateway.save(newUser);

        // Retorna o resultado
        final var userId = newUser.getId();
        final var userName = newUser.getName();

        return new AddUserOutputDto(
                userId,
                userName);

    }
}
