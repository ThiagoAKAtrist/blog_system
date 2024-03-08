package blogsystem.usecases.post.listAllPosts;

import blogsystem.domain.post.entities.Post;
import blogsystem.domain.post.gateway.PostGateway;
import blogsystem.usecases.Usecase;
import blogsystem.usecases.post.dto.PostDto;

import java.util.List;
import java.util.stream.Collectors;

public class ListAllPostsUsecase implements Usecase<ListAllPostsInputDto, ListAllPostsOutputDto> {

    private final PostGateway postGateway;

    public ListAllPostsUsecase(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    public static ListAllPostsUsecase create(PostGateway postGateway) {
        return new ListAllPostsUsecase(postGateway);
    }

    @Override
    public ListAllPostsOutputDto execute(ListAllPostsInputDto input) {
        List<Post> posts = postGateway.listAllPosts();

        List<PostDto> postDtos = posts.stream()
                .map(this::mapToPostDto)
                .collect(Collectors.toList());

        return new ListAllPostsOutputDto(postDtos);
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
