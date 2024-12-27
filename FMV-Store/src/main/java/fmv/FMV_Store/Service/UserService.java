package fmv.FMV_Store.Service;

import fmv.FMV_Store.Const.Role;
import fmv.FMV_Store.DTO.Request.UserCreationRequest;
import fmv.FMV_Store.DTO.Request.UserUpdateRequest;
import fmv.FMV_Store.DTO.Response.UserResponse;
import fmv.FMV_Store.Entity.User;
import fmv.FMV_Store.Exception.AppException;
import fmv.FMV_Store.Exception.ErrorCode;
import fmv.FMV_Store.Mapper.UserMapper;
import fmv.FMV_Store.Repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class UserService {

    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public UserResponse createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = UserMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);
        return UserMapper.toUserResponse(userRepository.save(user));

    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAllUsers() {
        log.info("Get all users");
        return userRepository.findAll().stream().map(UserMapper::toUserResponse).toList();
    }

    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUser(String id) {
        log.info("Get user with id {}", id);
        return UserMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        UserMapper.toUser(user, request);
        return UserMapper.toUserResponse(userRepository.save(user));

    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public UserResponse getMyInfor() {
        var context = SecurityContextHolder.getContext();
        var authentication = context.getAuthentication().getName();

        User user = userRepository.findByUsername(authentication).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        return UserMapper.toUserResponse(user);
    }
}
