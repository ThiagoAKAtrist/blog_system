package blogsystem.repositories.post.memory;

import blogsystem.domain.post.entities.Post;
import blogsystem.domain.post.gateway.PostGateway;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepositoryMemory implements PostGateway {

    private HashMap<String, Post> posts;

    private PostRepositoryMemory() {
        this.posts = new HashMap<>();
    }

    public static PostRepositoryMemory create() {
        return new PostRepositoryMemory();
    }

    @Override
    public void save(Post post) {
        this.posts.put(post.getId(), post);
    }

    @Override
    public Post find(String postId) {
        return this.posts.get(postId);
    }

    @Override
    public List<Post> list() {
        return this.posts.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Post> findByUserId(String userId) {
        return this.posts.values()
                .stream()
                .filter(post -> userId.equals(post.getAuthor().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> listPostsByAuthor(String authorId) {
        return this.posts.values()
                .stream()
                .filter(post -> authorId.equals(post.getAuthor().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> listAllPosts() {
        return this.posts.values().stream().collect(Collectors.toList());
    }
}
