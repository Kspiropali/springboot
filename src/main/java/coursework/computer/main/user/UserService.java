package coursework.computer.main.user;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        user.setDob(LocalDate.of(2020, Month.APRIL, 5));
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("user with id "+ userId + "does not exist");
        }

        userRepository.deleteById(userId);
    }

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
            boolean found = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$").matcher(dob).find();

            if(!found){
                System.out.println("Dob does not conform to Pattern(yyyy-mm-dd");
                return null;
            }
            user.setDob(LocalDate.parse(dob));
        }

        return user;
    }

    @Transactional
    public User getUser(Long userId) {

        return userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "user with id " + userId + "does not exist"
        ));
    }

    public Long checkuserDetails(String email, String password) {

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
