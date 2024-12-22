package fmv.FMV_Store.Controller;

import fmv.FMV_Store.DTO.Request.ApiResponse;
import fmv.FMV_Store.DTO.Request.UserCreationRequest;
import fmv.FMV_Store.Entity.User;
import fmv.FMV_Store.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse api = new ApiResponse<>();

        api.setCode(1000);
        api.setData(userService.createUser(request));
        return api;
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
