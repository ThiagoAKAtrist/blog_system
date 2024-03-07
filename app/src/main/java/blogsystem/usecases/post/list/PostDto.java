package blogsystem.usecases.post.list;

import blogsystem.domain.post.entities.Author;

public record PostDto(
        String postId,
        String title,
        Author author,
        String authorId,
        String content,
        String postingDate) {

}
