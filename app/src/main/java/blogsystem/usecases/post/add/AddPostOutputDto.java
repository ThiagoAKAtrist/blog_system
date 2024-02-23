package blogsystem.usecases.post.add;

public record AddPostOutputDto(
        String postId,
        String title,
        String authorUserId,
        String content,
        String postingDate) {

}
