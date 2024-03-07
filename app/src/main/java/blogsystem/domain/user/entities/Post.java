package blogsystem.domain.user.entities;

import blogsystem.domain.shared.entities.Entity;
import blogsystem.domain.shared.exceptions.DomainException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post extends Entity {

    private String title;
    private User author;
    private String content;
    private LocalDateTime postingDate;

    private Post(String id, String title, User author, String content) {
        super(id);
        this.title = title;
        this.author = author;
        this.content = content;
        this.postingDate = LocalDateTime.now();
        this.validate();
    }

    public static Post create(String title, User author, String content) {
        return new Post(
            UUID.randomUUID().toString(),
            title,
            author, 
            content);
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPostingDate() {
        return postingDate;
    }

    @Override
    protected void validate() {
        if (this.getId() == null) {
            throw new DomainException("Post id is required");
        }

        if (this.title == null || this.title.isEmpty() || this.title.length() > 50) {
            throw new DomainException("Post title is required and should not exceed 50 characters");
        }

        if (this.author == null) {
            throw new DomainException("Post author is required");
        }

        if (this.content == null || this.content.length() > 250) {
            throw new DomainException("Post content is required and should not exceed 250 characters");
        }
    }
}
