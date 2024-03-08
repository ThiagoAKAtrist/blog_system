package blogsystem.usecases.post.listByAuthor;

public record ListAuthorPostsInputDto(String authorId) {

    public String authorId() {
        return authorId;
    }
}
