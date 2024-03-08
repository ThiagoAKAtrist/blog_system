package blogsystem.usecases.post.listAllPosts;

import java.util.List;

import blogsystem.usecases.post.dto.PostDto;

public class ListAllPostsOutputDto {

    private List<PostDto> posts;

    public ListAllPostsOutputDto(List<PostDto> posts) {
        this.posts = posts;
    }
    
    public List<PostDto> getPosts() {
        return posts;
    }
    
}