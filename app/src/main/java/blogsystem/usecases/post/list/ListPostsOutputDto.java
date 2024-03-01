package blogsystem.usecases.post.list;

import java.util.List;

public class ListPostsOutputDto {

    private List<PostDto> posts;

    public ListPostsOutputDto(List<PostDto> posts) {
        this.posts = posts;
    }
    
    public List<PostDto> getPosts() {
        return posts;
    }
    
}
