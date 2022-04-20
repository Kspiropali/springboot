package coursework.computer.main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping(path = "/register")
    public void registerNewUser(@RequestBody User user){
        user.setEmail(user.getEmail().replace("%40", "@"));
        System.out.println(user.toString());
        userService.addNewUser(user);
    }

    @PostMapping(path = "/validate")
    public String checkDetails(@RequestParam("email") String email, @RequestParam("password") String password){
        return userService.checkuserDetails(email, password);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "/update/{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email) {
        userService.updateUser(userId, name, surname, password, email);
    }
}
