package fmv.FMV_Store.Service;

import fmv.FMV_Store.DTO.Request.UserCreationRequest;
import fmv.FMV_Store.Entity.User;
import fmv.FMV_Store.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        return userRepository.save(user);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String username) {
        return userRepository.findById(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId, UserCreationRequest request) {
        User user = getUser(userId);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        return userRepository.save(user);

    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
