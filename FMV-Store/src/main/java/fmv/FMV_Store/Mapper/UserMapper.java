package fmv.FMV_Store.Mapper;

import fmv.FMV_Store.DTO.Request.UserCreationRequest;
import fmv.FMV_Store.DTO.Request.UserUpdateRequest;
import fmv.FMV_Store.DTO.Response.UserResponse;
import fmv.FMV_Store.Entity.User;

public class UserMapper {

    public static User toUser(UserCreationRequest request) {
        if (request == null) return null;
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        return user;
    }
    public static void toUser(User us, UserUpdateRequest request) {
        if (request == null) {
            return;
        }
        us.setEmail(request.getEmail());
        us.setPassword(request.getPassword());
        us.setUsername(request.getUsername());
        us.setPhone(request.getPhone());
    }

    public static UserResponse toUserResponse(User user) {
        if (user == null) return null;
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
//        response.setPassword(user.getPassword());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setPhone(user.getPhone());
        response.setRoles(user.getRoles());
        return response;

    }
}
