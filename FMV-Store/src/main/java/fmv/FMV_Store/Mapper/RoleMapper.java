package fmv.FMV_Store.Mapper;

import fmv.FMV_Store.DTO.Request.RoleRequest;
import fmv.FMV_Store.DTO.Response.PermissionResponse;
import fmv.FMV_Store.DTO.Response.RoleResponse;
import fmv.FMV_Store.Entity.Permission;
import fmv.FMV_Store.Entity.Role;

import java.util.Set;
import java.util.stream.Collectors;

public class RoleMapper {

    public static Role toRole(RoleRequest request) {
        if (request == null) return null;
        Role role = new Role();
        role.setName(request.getName());
        role.setDescription(request.getDescription());

        Set<Permission> permissonList = request.getPermissions()
                .stream()
                .map(name -> {
                    Permission permission = new Permission();
                    permission.setName(name);
                    return permission;

                }).collect(Collectors.toSet());

        role.setPermissions(permissonList);
        return role;
    }
    public static RoleResponse toRoleResponse(Role role) {
        if (role == null) return null;
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setName(role.getName());
        roleResponse.setDescription(role.getDescription());
        Set<PermissionResponse> permissions = role.getPermissions()
                .stream()
                .map(permission -> {
                    PermissionResponse permissionResponse = new PermissionResponse();
                    permissionResponse.setName(permission.getName());
                    permissionResponse.setDescription(permission.getDescription());
                    return permissionResponse;
                })
                .collect(Collectors.toSet());
        roleResponse.setPermissions(permissions);
        return roleResponse;

    }
}
