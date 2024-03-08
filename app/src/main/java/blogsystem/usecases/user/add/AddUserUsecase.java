package blogsystem.usecases.user.add;

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

    public String addUser(String name, String email, String password, String nickname) {
        // Lógica para adicionar o usuário aqui
        // Por exemplo, crie um novo usuário com os dados fornecidos
        User newUser = User.create(name, email, password, nickname);

        // Persiste no banco de dados utilizando o gateway
        userGateway.save(newUser);

        // Retorna o ID do usuário gerado
        return newUser.getId();
    }

    @Override
    public AddUserOutputDto execute(final AddUserInputDto input) {

        // Criação de acordo com as regras de domínio
        final User newUser = User.create(
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
