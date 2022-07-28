package pl.fissst.lbd.queues.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fissst.lbd.queues.dto.UserDto;
import pl.fissst.lbd.queues.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //POST /user - USER_CREATED
    @PostMapping
    public void CreateUser(@RequestBody UserDto userDto){
        userService.CreateUser(userDto);
    }

}
