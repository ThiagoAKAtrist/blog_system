package blogsystem.usecases.post.find;

import blogsystem.domain.post.entities.Author;

public record FindPostOutputDto(
        String postId,
        String title,
        Author author,
        String authorId,
        String content,
        String postingDate) {

}
