package blogsystem.usecases.user.add;

public record AddUserInputDto(
        String aName,
        String anEmail,
        String aPassword,
        String aNickname) {

}
