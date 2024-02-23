package blogsystem.usecases.user.find;

public record FindUserOutputDto(
        String userId,
        String name,
        String email,
        String nickname) {

}
