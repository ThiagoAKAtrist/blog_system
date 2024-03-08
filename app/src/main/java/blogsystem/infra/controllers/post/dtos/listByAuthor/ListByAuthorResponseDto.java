package blogsystem.infra.controllers.post.dtos.listByAuthor;

import java.time.LocalDateTime;

public record ListByAuthorResponseDto(
        String postId,
        String title,
        String content,
        LocalDateTime postingDate
) {
}
