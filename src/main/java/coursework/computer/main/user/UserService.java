package coursework.computer.main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public void updateUser(Long userId, String name, String surname, String password, String email) {
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
    }

    @Transactional
    public User getUser(Long userId) {

        return userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "user with id " + userId + "does not exist"
        ));
    }

    public int checkuserDetails(String email, String password) {
        String finalEmail = email.split("&")[0].split("=")[1].replace("%40", "@");
        String finalPassword = email.split("&")[1].split("=")[1];

        System.out.println("EMAIL: "+finalEmail+"\nPASS: "+finalPassword);

        User user = userRepository.findUserByEmail(finalEmail).orElseThrow(() -> new IllegalStateException(
                "User with email: " + finalEmail + " does not exist"
        ));

        if(finalPassword.equals(user.getPassword())){
            System.out.println("Passwords Match!");
            return 0;
        }else {
            System.out.println("Password do not match!");
            return 1;
        }
    }
}
