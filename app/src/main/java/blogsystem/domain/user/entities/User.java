package blogsystem.domain.user.entities;

import blogsystem.domain.shared.entities.Entity;
import blogsystem.domain.shared.exceptions.DomainException;
import blogsystem.domain.post.entities.Author;
import blogsystem.domain.post.entities.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends Entity {

    private String name;
    private String email;
    private String password;
    private String nickname;
    private List<Post> posts;
    private Author author;

    private User(String id, String name, String email, String password, String nickname) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.posts = new ArrayList<>();
        this.validate();
    }

    public static User create(String aName, String anEmail, String aPassword, String aNickname) {
        return new User(
            UUID.randomUUID().toString(),
            aName,
            anEmail,
            aPassword,
            aNickname);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    @Override
    protected void validate() {
        if (this.getId() == null) {
            throw new DomainException("User id is required");
        }

        if (this.name == null || this.name.isEmpty()) {
            throw new DomainException("User name is required");
        }

        if (this.email == null || this.email.isEmpty()) {
            throw new DomainException("User email is required");
        }

        if (this.password == null || this.password.isEmpty()) {
            throw new DomainException("User password is required");
        }

        if (this.nickname == null || this.nickname.isEmpty()) {
            throw new DomainException("User nickname is required");
        }
    }

}
