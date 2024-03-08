package blogsystem.usecases.post.find;

import blogsystem.domain.post.entities.Post;
import blogsystem.domain.post.gateway.PostGateway;
import blogsystem.usecases.Usecase;
import blogsystem.usecases.exceptions.NotFoundException;

public class FindPostUsecase implements Usecase<FindPostInputDto, Post> {

    private final PostGateway postGateway;

    private FindPostUsecase(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    public static FindPostUsecase create(final PostGateway postGateway) {
        return new FindPostUsecase(postGateway);
    }

    @Override
    public Post execute(FindPostInputDto input) {
        Post foundPost = postGateway.find(input.postId());

        if (foundPost == null) {
            throw new NotFoundException("Post not found");
        }

        return foundPost;
    }
}
