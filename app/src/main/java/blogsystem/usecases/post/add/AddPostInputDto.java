package blogsystem.usecases.post.add;

import blogsystem.domain.post.entities.Author;

public record AddPostInputDto(
        String title,
        Author author,
        String content) {

    public AddPostInputDto(String title, String authorId, String content) {
        this(title, new Author(authorId, null, null, null, null), content);
    }

    // Adicione o método authorId() à classe
    public String authorId() {
        return author.getId();
    }
}
