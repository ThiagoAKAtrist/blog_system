package blogsystem.domain.post.policies;

import blogsystem.domain.post.entities.Post;
import blogsystem.domain.shared.exceptions.DomainException;
import blogsystem.domain.shared.policies.Policy;

public class PostContentLengthPolicy implements Policy<Post> {

    public static void isAccording(Post entity) {
        new PostContentLengthPolicy().validate(entity);
    }

    @Override
    public void validate(Post entity) {
        if (entity.getContent().length() > 250) {
            throw new DomainException("Post content exceeds the maximum length of 250 characters");
        }
    }
}
