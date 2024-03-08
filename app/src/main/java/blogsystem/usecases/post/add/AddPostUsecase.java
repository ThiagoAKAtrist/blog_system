package blogsystem.usecases.post.add;

import blogsystem.domain.post.entities.Post;
import blogsystem.domain.post.entities.Author;
import blogsystem.domain.post.gateway.PostGateway;
import blogsystem.domain.user.gateway.UserGateway;
import blogsystem.usecases.Usecase;
import blogsystem.usecases.exceptions.NotFoundException;

public class AddPostUsecase implements Usecase<AddPostInputDto, Post> {

    private final PostGateway postGateway;
    private final UserGateway userGateway;

    public AddPostUsecase(PostGateway postGateway, UserGateway userGateway) {
        this.postGateway = postGateway;
        this.userGateway = userGateway;
    }

    public static AddPostUsecase create(PostGateway postGateway, UserGateway userGateway) {
        return new AddPostUsecase(postGateway, userGateway);
    }

    @Override
    public Post execute(AddPostInputDto input) {

        // Busca do usuário pelo ID
        Author author = userGateway.findByAuthor(input.authorId());

        if (author == null) {
            throw new NotFoundException("Author not found");
        }

        // Criação de um novo post
        Post newPost = Post.create(
                input.title(),
                author,
                input.content());

        // Salvando o post
        postGateway.save(newPost);

        // Retornando o post criado
        return newPost;
    }
}
