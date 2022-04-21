package coursework.computer.main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
    public Long checkDetails(@RequestParam("email") String email, @RequestParam("password") String password){
        return userService.checkuserDetails(email, password);
    }

    @PostMapping(path = "/delete/{userId}")
    public void deleteUser(@RequestParam("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "/update/{userId}")
    public User updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String dob){
        System.out.println("\nUserID: "+userId+"\nFirstName: "+name+"\nSurname: "+surname+"\nPassword: "+password+"\nEmail: "+email+"\nDoB: "+dob);
        return userService.updateUser(userId, name, surname, password, email, dob);
    }
}
