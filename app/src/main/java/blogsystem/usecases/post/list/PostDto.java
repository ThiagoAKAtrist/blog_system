package blogsystem.usecases.post.list;

public record PostDto(
        String postId,
        String title,
        String authorUserId,
        String content,
        String postingDate) {

}
