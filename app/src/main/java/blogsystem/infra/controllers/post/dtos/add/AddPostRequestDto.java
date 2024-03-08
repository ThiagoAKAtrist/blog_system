package blogsystem.infra.controllers.post.dtos.add;

import blogsystem.domain.post.entities.Author;

public class AddPostRequestDto {

    private String title;
    private Author author;
    private String content;

    // Construtores, getters e setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
