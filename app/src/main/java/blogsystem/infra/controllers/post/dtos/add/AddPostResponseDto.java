package blogsystem.infra.controllers.post.dtos.add;

public class AddPostResponseDto {

    private String postId;
    private String title;
    private String authorId;
    private String content;

    // Construtores, getters e setters

    public AddPostResponseDto(String postId, String title, String authorId, String content) {
        this.postId = postId;
        this.title = title;
        this.authorId = authorId;
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
