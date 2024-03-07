package blogsystem.domain.post.entities;

import blogsystem.domain.shared.entities.Entity;
import blogsystem.domain.shared.exceptions.DomainException;
import java.util.UUID;

public class Author extends Entity {

    private String name;
    private String email;
    private String password;
    private String nickname;

    public Author(String id, String name, String email, String password, String nickname) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.validate();
    }

    public static Author create(String aName, String anEmail, String aPassword, String aNickname) {
        return new Author(
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
