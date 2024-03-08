package blogsystem.usecases.post.listByAuthor;

import java.util.List;

import blogsystem.usecases.post.dto.PostDto;

public class ListAuthorPostsOutputDto {

    private List<PostDto> posts;

    public ListAuthorPostsOutputDto(List<PostDto> posts) {
        this.posts = posts;
    }
    
    public List<PostDto> getPosts() {
        return posts;
    }
    
}
