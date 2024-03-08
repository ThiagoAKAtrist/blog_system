package blogsystem.usecases.post.listByAuthor;

import blogsystem.domain.post.entities.Post;
import blogsystem.domain.post.gateway.PostGateway;
import blogsystem.usecases.Usecase;
import blogsystem.usecases.post.dto.PostDto;

import java.util.List;
import java.util.stream.Collectors;

public class ListAuthorPostsUsecase implements Usecase<ListAuthorPostsInputDto, ListAuthorPostsOutputDto> {

    private final PostGateway postGateway;

    public ListAuthorPostsUsecase(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    public static ListAuthorPostsUsecase create(PostGateway postGateway) {
        return new ListAuthorPostsUsecase(postGateway);
    }

    @Override
    public ListAuthorPostsOutputDto execute(ListAuthorPostsInputDto input) {
        List<Post> posts = postGateway.listPostsByAuthor(input.authorId());

        List<PostDto> postDtos = posts.stream()
                .map(this::mapToPostDto)
                .collect(Collectors.toList());

        return new ListAuthorPostsOutputDto(postDtos);
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
