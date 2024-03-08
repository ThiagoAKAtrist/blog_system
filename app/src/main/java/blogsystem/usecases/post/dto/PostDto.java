package blogsystem.usecases.post.dto;

import blogsystem.domain.post.entities.Author;

public record PostDto(
        String postId,
        String title,
        Author author,
        String authorId,
        String content,
        String postingDate) {

}
