package blogsystem.repositories.user.jpa.model;

import java.util.List;

import blogsystem.repositories.post.jpa.model.PostJpaModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "User")
@Table(name = "users")
public class UserJpaModel {

    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;

    @OneToMany(
        targetEntity = PostJpaModel.class,
        cascade = CascadeType.REMOVE,
        fetch = FetchType.LAZY,
        mappedBy = "author"
    )
    private List<PostJpaModel> posts;

    public UserJpaModel(){

    }

    public UserJpaModel(String id, String name, String email, String password, String nickname,
            List<PostJpaModel> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.posts = posts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<PostJpaModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostJpaModel> posts) {
        this.posts = posts;
    }

    
}
