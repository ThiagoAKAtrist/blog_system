package blogsystem.domain.post.entities;

import blogsystem.domain.user.entities.User;
import blogsystem.domain.shared.aggregatte.AggregatteRoot;
import blogsystem.domain.shared.entities.Entity;
import blogsystem.domain.shared.exceptions.DomainException;
import blogsystem.domain.post.policies.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post extends Entity implements AggregatteRoot {

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

    public static Post with(String id, String title, User author, String content) {
        return new Post(
                id,
                title,
                author,
                content);
    }

    protected void validate() {
        if (this.getId() == null) {
            throw new DomainException("Post id is required");
        }

        if (this.title == null || this.title.isEmpty()) {
            throw new DomainException("Post title is required");
        }

        if (this.author == null) {
            throw new DomainException("Post author is required");
        }

        if (this.content == null || this.content.isEmpty()) {
            throw new DomainException("Post content is required");
        }

        PostContentLengthPolicy.isAccording(this);
        PostTitleLengthPolicy.isAccording(this);

        // Adicione outras validações conforme necessário
    }

    public void changeContent(String content) {
        this.content = content;
        this.validate();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the author
     */
    public User getAuthor() {
        return author;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the postingDate
     */
    public LocalDateTime getPostingDate() {
        return postingDate;
    }

    public String getPostId() {
        return getId();
    }
}
