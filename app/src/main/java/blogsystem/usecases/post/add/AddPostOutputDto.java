package blogsystem.usecases.post.add;

import blogsystem.domain.post.entities.Author;

public record AddPostOutputDto(
        String postId,
        String title,
        Author author,
        String authorId,
        String content,
        String postingDate) {

}
