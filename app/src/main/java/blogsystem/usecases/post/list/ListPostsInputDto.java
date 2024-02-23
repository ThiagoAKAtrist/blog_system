package blogsystem.usecases.post.list;

public record ListPostsInputDto(String authorUserId) {

    public String authorUserId() {
        return authorUserId;
    }
}
