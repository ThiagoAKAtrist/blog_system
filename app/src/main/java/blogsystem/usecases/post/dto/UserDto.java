package blogsystem.usecases.post.dto;

public record UserDto(
        String userId,
        String name,
        String email,
        String nickname) {

}
