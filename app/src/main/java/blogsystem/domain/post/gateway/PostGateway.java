package blogsystem.domain.post.gateway;

import blogsystem.domain.post.entities.Post;

import java.util.List;

public interface PostGateway {

    void save(Post post);
    Post find(String postId);
    List<Post> list();
    List<Post> findByUserId(String userId);
    List<Post> listPostsByAuthor(String authorUserId);

}
