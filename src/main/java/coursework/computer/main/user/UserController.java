package coursework.computer.main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//main controller of the Object User
//handles the backend mapping to the URL given
//also controls the Submit method(POST, GET, PUT, DELETE)
//all of which are non-token based and thus the need of the Object CorsConfigurer
@RestController
/*@CrossOrigin*/
//getting the BASE url for the UserController
//that means all the below requests need to start from http(s)://localhost:(port number)/users
@RequestMapping(path = "/users")
public class UserController {

    //following Business grade programming, we need a Main in the Middle service between the
    //Object User main controller and database handler repository
    private final UserService userService;

    //
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //returns a json format will all users
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }


    //returns a user in json format upon receiving an existing userID
    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    //add or register a user in the database. The Object User consists of: name, surname, email, password and dob
    //all of which need to be sent in order to create the user
    @PostMapping(path = "/register")
    public void registerNewUser(@RequestBody User user){
        user.setEmail(user.getEmail().replace("%40", "@"));

        userService.addNewUser(user);
    }

    //The login page is dependent on this mapping. Given an email and password, return either 500, 200 in the request
    //body with a response code of 200(OK) OR response code of 400 if the server is not running OR 400 if the email was
    //not found
    @PostMapping(path = "/validate")
    public Long checkDetails(@RequestParam("email") String email, @RequestParam("password") String password){
        return userService.checkUserDetails(email, password);
    }

    //deletes a User given a userID. 200 for ok 500 for no id found
    @DeleteMapping(path = "/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId){
        return userService.deleteUser(userId);
    }

    //Given a userId updates details of a user. (required=false) means that not all values are needed at the same time.
    @PutMapping(path = "/update/{userId}")
    public User updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String dob){
        return userService.updateUser(userId, name, surname, password, email, dob);
    }
}
