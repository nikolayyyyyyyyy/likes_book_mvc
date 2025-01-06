package like_book.services.impl;
import jakarta.transaction.Transactional;
import like_book.config.UserSession;
import like_book.models.dtos.UserLoginDTO;
import like_book.models.dtos.UserRegisterDTO;
import like_book.models.entities.User;
import like_book.repositories.UserRepository;
import like_book.services.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserSession userSession;
    public UserServiceImpl(UserRepository userRepository,
                           UserSession userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    @Override
    public boolean createUser(UserRegisterDTO user) {
        if(this.userRepository.findByUsername(user.getUsername()) != null
        || this.userRepository.findByEmail(user.getEmail()) != null){

            return false;
        }

        this.userRepository.save(mapToUser(user));
        return true;
    }

    @Override
    public Set<User> getAllUsers() {
        if(this.userRepository.findAll().isEmpty()){
            return new HashSet<>();
        }
        return new HashSet<>(this.userRepository.findAll());
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        User user = this.userRepository.findByUsername(userLoginDTO.getUsername());

        if(!Objects.equals(user.getPassword(), userLoginDTO.getPassword())){
            return false;
        }

        userSession.logIn(user.getId(),user.getUsername());
        return true;
    }

    @Override
    public void logout() {
        this.userSession.logOut();
    }

    @Override
    public User getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    private User mapToUser(UserRegisterDTO userRegisterDTO){
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(userRegisterDTO.getPassword());
        user.setEmail(userRegisterDTO.getEmail());

        return user;
    }
}