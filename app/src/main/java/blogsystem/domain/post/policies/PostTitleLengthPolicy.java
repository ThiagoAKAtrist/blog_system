package blogsystem.domain.post.policies;

import blogsystem.domain.post.entities.Post;
import blogsystem.domain.shared.exceptions.DomainException;
import blogsystem.domain.shared.policies.Policy;

public class PostTitleLengthPolicy implements Policy<Post> {

    public static void isAccording(Post entity) {
        new PostTitleLengthPolicy().validate(entity);
    }

    @Override
    public void validate(Post entity) {
        if (entity.getTitle().length() > 50) {
            throw new DomainException("Post title exceeds the maximum length of 50 characters");
        }
    }
}
