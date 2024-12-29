package fmv.FMV_Store.Mapper;

import fmv.FMV_Store.DTO.Request.PermissionRequest;
import fmv.FMV_Store.DTO.Request.UserUpdateRequest;
import fmv.FMV_Store.DTO.Response.PermissionResponse;
import fmv.FMV_Store.Entity.Permission;
import fmv.FMV_Store.Entity.User;

public class PermissionMapper {
    public static void toPermission(Permission ps, PermissionRequest request) {
        if (request == null) {
            return;
        }
        ps.setName(request.getName());
        ps.setDescription(request.getDescription());
    }
    public static Permission toPermission( PermissionRequest request) {
        if (request == null) {
            return null;
        }
        Permission ps = new Permission();
        ps.setName(request.getName());
        ps.setDescription(request.getDescription());
        return ps;
    }


    public static PermissionResponse toPermissionResponse(Permission request) {
        if (request == null) {
            return null;
        }
        PermissionResponse ps = new PermissionResponse();
        ps.setName(request.getName());
        ps.setDescription(request.getDescription());
        return ps;
    }
}
