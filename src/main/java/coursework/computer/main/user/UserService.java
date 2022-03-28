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
    public void updateUser(Long userId, String name, String surname, String email) {
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
}
