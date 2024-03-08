package blogsystem.repositories.post.jpa.model;

import java.time.LocalDateTime;

import blogsystem.repositories.user.jpa.model.UserJpaModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity(name = "Post")
@Table(name = "posts")
public class PostJpaModel {

    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    @Column(name = "title", nullable = false)
    private String title;
    
    @ManyToOne(
        targetEntity = UserJpaModel.class,
        optional = false,
        fetch = FetchType.EAGER
    )
    @JoinColumns({
        @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false),
        @JoinColumn(name = "author_nickname", referencedColumnName = "nickname", nullable = false)
    })
    private UserJpaModel author;

    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public PostJpaModel(){ 
    }

    /**
     * @param id
     * @param title
     * @param author
     * @param content
     * @param createdAt
     */
    public PostJpaModel(String id, String title, UserJpaModel author, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserJpaModel getAuthor() {
        return author;
    }

    public void setAuthor(UserJpaModel author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    
}
