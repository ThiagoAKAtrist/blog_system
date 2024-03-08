package blogsystem.infra.controllers.user.dtos.add; // Place in appropriate controller DTO package

public record AddUserRequestDto(
    String name,
    String email,
    String password,
    String nickname
) {

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getNickname(){
        return nickname;
    }

    
}
