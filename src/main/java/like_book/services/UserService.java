package like_book.services;

import like_book.models.dtos.UserLoginDTO;
import like_book.models.dtos.UserRegisterDTO;
import like_book.models.entities.User;

import java.util.Set;

public interface UserService {

    public boolean createUser(UserRegisterDTO user);
    public Set<User> getAllUsers();
    public boolean login(UserLoginDTO userLoginDTO);
    public void logout();
    public User getByUsername(String username);
}
