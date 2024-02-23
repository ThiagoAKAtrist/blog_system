package blogsystem.usecases.post.add;

import blogsystem.domain.post.entities.Post;
import blogsystem.domain.post.gateway.PostGateway;
import blogsystem.domain.user.entities.User;
import blogsystem.domain.user.gateway.UserGateway;
import blogsystem.usecases.Usecase;

// import java.time.LocalDateTime;

public class AddPostUsecase implements Usecase<AddPostInputDto, AddPostOutputDto> {

    private final PostGateway postGateway;
    private final UserGateway userGateway; // Adicione um UserGateway

    public AddPostUsecase(PostGateway postGateway, UserGateway userGateway) {
        this.postGateway = postGateway;
        this.userGateway = userGateway;
    }

    public static AddPostUsecase create(PostGateway postGateway, UserGateway userGateway) {
        return new AddPostUsecase(postGateway, userGateway);
    }

    @Override
    public AddPostOutputDto execute(AddPostInputDto input) {
        // Aqui você pode fazer validações adicionais, se necessário

        // Busca do usuário pelo ID
        User author = userGateway.find(input.authorUserId());

        // if (author == null) {
        //     // Trate a situação em que o usuário não foi encontrado, lançando uma exceção ou retornando um DTO de erro
        //     // Por exemplo, você pode criar um ErrorResponseDto e retorná-lo
        //     throw new UserNotFoundException("User not found");
        // }

        // Criação de um novo post
        Post newPost = Post.create(
                input.title(),
                author,
                input.content());

        // Salvando o post
        postGateway.save(newPost);

        // Construção do DTO de saída
        return new AddPostOutputDto(
                newPost.getPostId(),
                newPost.getTitle(),
                newPost.getAuthor().getId(),
                newPost.getContent(),
                newPost.getPostingDate().toString() // Aqui você pode formatar a data conforme necessário
        );
    }
}