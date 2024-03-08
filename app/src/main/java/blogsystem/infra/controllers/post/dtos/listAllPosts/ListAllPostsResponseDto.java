package blogsystem.infra.controllers.post.dtos.listAllPosts;

import java.time.LocalDateTime;

public record ListAllPostsResponseDto(
        String postId,
        String title,
        String authorId,
        String content,
        LocalDateTime postingDate
) {
}
