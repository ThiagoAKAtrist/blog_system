package blogsystem.infra.controllers.post;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import blogsystem.domain.post.entities.Author;
import blogsystem.domain.post.entities.Post;
import blogsystem.domain.post.gateway.PostGateway;
import blogsystem.domain.user.gateway.UserGateway;
import blogsystem.infra.controllers.post.dtos.add.AddPostRequestDto;
import blogsystem.infra.controllers.post.dtos.add.AddPostResponseDto;
import blogsystem.infra.controllers.post.dtos.find.FindPostResponseDto;
import blogsystem.infra.controllers.post.dtos.listAllPosts.ListAllPostsResponseDto;
import blogsystem.infra.controllers.post.dtos.listByAuthor.ListByAuthorResponseDto;
import blogsystem.usecases.post.add.AddPostInputDto;
import blogsystem.usecases.post.add.AddPostUsecase;
import blogsystem.usecases.post.find.FindPostInputDto;
import blogsystem.usecases.post.find.FindPostUsecase;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostGateway postGateway;
    private final UserGateway userGateway;

    // Injetando as instâncias necessárias no construtor
    public PostController(PostGateway postGateway, UserGateway userGateway) {
        this.postGateway = postGateway;
        this.userGateway = userGateway;
    }

    @PostMapping("/add")
    public AddPostResponseDto add(@RequestBody AddPostRequestDto request) {
        Author author = request.getAuthor();
        AddPostInputDto input = new AddPostInputDto(request.getTitle(), author, request.getContent());

        Post result = AddPostUsecase.create(postGateway, userGateway).execute(input);

        return new AddPostResponseDto(
            result.getPostId(),
            result.getTitle(),
            result.getAuthor().getId(),
            result.getContent()
        );
    }

    @GetMapping("/{postId}")
    public FindPostResponseDto find(@PathVariable String postId) {
        FindPostInputDto input = new FindPostInputDto(postId);

        Post result = FindPostUsecase.create(postGateway).execute(input);

        return new FindPostResponseDto(
            result.getPostId(),
            result.getTitle(),
            result.getAuthor().getId(),
            result.getContent(),
            result.getPostingDate()
        );
    }

    @GetMapping("/listAll")
    public List<ListAllPostsResponseDto> listAllPosts() {
        List<Post> posts = postGateway.listAllPosts();

        return posts.stream()
                .map(post -> new ListAllPostsResponseDto(
                        post.getPostId(),
                        post.getTitle(),
                        post.getAuthor().getId(),
                        post.getContent(),
                        post.getPostingDate()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/listByAuthor/{authorId}")
    public List<ListByAuthorResponseDto> listByAuthor(@PathVariable String authorId) {
        List<Post> posts = postGateway.listPostsByAuthor(authorId);

        return posts.stream()
                .map(post -> new ListByAuthorResponseDto(
                        post.getPostId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getPostingDate()
                ))
                .collect(Collectors.toList());
    }
}
