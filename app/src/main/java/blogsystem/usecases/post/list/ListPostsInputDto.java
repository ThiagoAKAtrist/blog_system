package blogsystem.usecases.post.list;

public record ListPostsInputDto(String authorId) {

    public String authorId() {
        return authorId;
    }
}
