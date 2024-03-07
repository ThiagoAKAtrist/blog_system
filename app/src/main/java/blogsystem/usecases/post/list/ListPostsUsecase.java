package blogsystem.usecases.post.list;

import blogsystem.domain.post.entities.Post;
import blogsystem.domain.post.gateway.PostGateway;
import blogsystem.usecases.Usecase;

import java.util.List;
import java.util.stream.Collectors;

public class ListPostsUsecase implements Usecase<ListPostsInputDto, ListPostsOutputDto> {

    private final PostGateway postGateway;

    public ListPostsUsecase(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    public static ListPostsUsecase create(PostGateway postGateway) {
        return new ListPostsUsecase(postGateway);
    }

    @Override
    public ListPostsOutputDto execute(ListPostsInputDto input) {
        List<Post> posts = postGateway.listPostsByAuthor(input.authorId());

        List<PostDto> postDtos = posts.stream()
                .map(this::mapToPostDto)
                .collect(Collectors.toList());

        return new ListPostsOutputDto(postDtos);
    }

    private PostDto mapToPostDto(Post post) {
        return new PostDto(
                post.getPostId(),
                post.getTitle(),
                post.getAuthor(),
                post.getAuthor().getId(),
                post.getContent(),
                post.getPostingDate().toString()
        );
    }
}
