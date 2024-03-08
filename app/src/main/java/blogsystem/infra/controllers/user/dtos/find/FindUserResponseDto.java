package blogsystem.infra.controllers.user.dtos.find; // Place in appropriate controller DTO package

public record FindUserResponseDto(
    String id,
    String name,
    String email,
    String nickname
) {

}
