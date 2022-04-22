package coursework.computer.main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {

    //Instantiating the userRepository, which contains all of the sql commands for us by default.
    //The service takes input from the userController and then continues to send or retrieve information
    //to the userRepository which then goes to the database
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        System.out.println("Get all users request!");
        //equals with query= ("SELECT * FROM User")
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        //checking if the email exists in the database. The email must be unique for obvious purposes
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        System.out.println(user);
        user.setDob(user.getDob());
        userRepository.save(user);

    }

    public String deleteUser(Long userId) {
        // this query is equal to query= ("SELECT s FROM User s WHERE s.id= ?1")
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            System.out.println("user with id "+ userId + "does not exist");
            return "500";
        }
        System.out.println("Permanently deleting user with id: "+userId);
        userRepository.deleteById(userId);
        return "200";
    }

    //first checks the input taken from the controller then passes them over to the repo which then go to database
    @Transactional
    public User updateUser(Long userId, String name, String surname, String password, String email, String dob) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "user with id " + userId + "does not exist"
        ));

        if(name != null &&
                name.length()>0 &&
                !Objects.equals(user.getName(), name)){
            user.setName(name);
        }

        if(surname != null &&
                surname.length()>0 &&
                !Objects.equals(user.getSurname(), surname)){
            user.setSurname(surname);
        }

        if(password != null &&
                password.length()>0 &&
                !Objects.equals(user.getPassword(), password)){
            user.setPassword(password);
        }

        if(email != null &&
                email.length()>0 &&
                !Objects.equals(user.getEmail(), email)){
            user.setEmail(email);
        }

        if(dob != null &&
                dob.length()>0 &&
                !Objects.equals(user.getDob(), LocalDate.parse(dob))){
            //using regex for validation
            boolean found = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$").matcher(dob).find();

            if(!found){
                System.out.println("Dob does not conform to Pattern(yyyy-mm-dd");
                return null;
            }
            user.setDob(LocalDate.parse(dob));
        }

        System.out.println("\nUserID: "+userId+"\nFirstName: "+name+"\nSurname: "+surname+"\nPassword: "+password+"\nEmail: "+email+"\nDoB: "+dob);
        return user;
    }

    //basically checks if user is present
    @Transactional
    public User getUser(Long userId) {

        return userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "user with id " + userId + "does not exist"
        ));
    }

    //this is being used by the validateDetails(). checks for match combo of email+password and returns the id
    //so that the id is stored as cookie and fast accessed for the rest of the session
    public Long checkUserDetails(String email, String password) {

        System.out.println("EMAIL: "+email+"\nPASS: "+password);

        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new IllegalStateException(
                "User with email: " + email + " does not exist"
        ));

        if(password.equals(user.getPassword())){
            System.out.println("Passwords Match!");
            return user.getId();
        }else {
            System.out.println("Password do not match!");
            return 0L;
        }
    }
}
