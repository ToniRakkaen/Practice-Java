package fmv.FMV_Store.Service;


import fmv.FMV_Store.DTO.Request.RoleRequest;
import fmv.FMV_Store.DTO.Response.RoleResponse;
import fmv.FMV_Store.Entity.Role;
import fmv.FMV_Store.Mapper.RoleMapper;
import fmv.FMV_Store.Repository.PermissionRepository;
import fmv.FMV_Store.Repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;

    public RoleResponse creteRole(RoleRequest role) {
        Role roleEntity = RoleMapper.toRole(role, permissionRepository);

//        roleRepository.save(roleEntity);
        return RoleMapper.toRoleResponse(roleEntity);
    }
}
