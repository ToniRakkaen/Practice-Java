package fmv.FMV_Store.Controller;

import fmv.FMV_Store.DTO.Request.UserCreationRequest;
import fmv.FMV_Store.Entity.User;
import fmv.FMV_Store.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUsers() {
    return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userName) {
        return userService.getUser(userName);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userId, @RequestBody UserCreationRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("{userId}")
    ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
