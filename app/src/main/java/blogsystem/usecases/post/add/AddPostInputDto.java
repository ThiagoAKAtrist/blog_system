package blogsystem.usecases.post.add;

public record AddPostInputDto(
        String title,
        String authorUserId,
        String content) {

}
