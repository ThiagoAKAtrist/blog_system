package blogsystem.usecases.post.find;

public record FindPostOutputDto(
        String postId,
        String title,
        String authorUserId,
        String content,
        String postingDate) {

}
