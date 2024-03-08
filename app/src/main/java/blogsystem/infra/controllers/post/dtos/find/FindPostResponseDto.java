package blogsystem.infra.controllers.post.dtos.find;

import java.time.LocalDateTime;

public record FindPostResponseDto(
        String postId,
        String title,
        String authorId,
        String content,
        LocalDateTime postingDate) {

}
