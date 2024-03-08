package blogsystem.infra.controllers.user;

import org.springframework.web.bind.annotation.*;
import blogsystem.usecases.user.add.AddUserUsecase;
import blogsystem.usecases.user.find.FindUserInputDto;
import blogsystem.usecases.user.find.FindUserOutputDto;
import blogsystem.usecases.user.find.FindUserUsecase;
import blogsystem.infra.controllers.user.dtos.add.AddUserRequestDto;
import blogsystem.infra.controllers.user.dtos.add.AddUserResponseDto;
import blogsystem.infra.controllers.user.dtos.find.FindUserResponseDto;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final AddUserUsecase addUserUsecase;
    private final FindUserUsecase findUserUsecase;

    public UserController(AddUserUsecase addUserUsecase, FindUserUsecase findUserUsecase) {
        this.addUserUsecase = addUserUsecase;
        this.findUserUsecase = findUserUsecase;
    }

    @PostMapping
    public AddUserResponseDto addUser(@RequestBody AddUserRequestDto requestDto) {
        String userId = addUserUsecase.addUser(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword(),
                requestDto.getNickname());
        return new AddUserResponseDto(userId, requestDto.getName(), requestDto.getEmail());
    }

    @GetMapping("/{userId}")
public FindUserResponseDto getUserById(@PathVariable String userId) {
    
    FindUserInputDto inputDto = new FindUserInputDto(userId);

    FindUserOutputDto outputDto = findUserUsecase.execute(inputDto);

    return new FindUserResponseDto(
            outputDto.userId(),
            outputDto.name(),
            outputDto.email(),
            outputDto.nickname());
}
}
