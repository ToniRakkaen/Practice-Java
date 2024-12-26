package fmv.FMV_Store.Controller;

import fmv.FMV_Store.DTO.Request.ApiResponse;
import fmv.FMV_Store.DTO.Request.UserCreationRequest;
import fmv.FMV_Store.DTO.Request.UserUpdateRequest;
import fmv.FMV_Store.DTO.Response.UserResponse;
import fmv.FMV_Store.Entity.User;
import fmv.FMV_Store.Service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse api = new ApiResponse<>();

        api.setCode(1000);
        api.setData(userService.createUser(request));
        return api;
    }

    @GetMapping
    ApiResponse<Object> getAllUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info("authority: {}", grantedAuthority));

        return ApiResponse.builder()
                .data(userService.getAllUsers())
                .build();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String userName) {
        return userService.getUser(userName);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("{userId}")
    ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
