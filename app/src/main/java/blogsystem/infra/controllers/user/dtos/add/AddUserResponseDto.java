package blogsystem.infra.controllers.user.dtos.add; // Place in appropriate controller DTO package

public record AddUserResponseDto(
    String id,
    String name,
    String email
) {

}
