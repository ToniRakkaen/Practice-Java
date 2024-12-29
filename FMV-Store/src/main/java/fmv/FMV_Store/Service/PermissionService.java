package fmv.FMV_Store.Service;

import fmv.FMV_Store.DTO.Request.PermissionRequest;
import fmv.FMV_Store.DTO.Response.PermissionResponse;
import fmv.FMV_Store.Entity.Permission;
import fmv.FMV_Store.Mapper.PermissionMapper;
import fmv.FMV_Store.Repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@Service
public class PermissionService {
    PermissionRepository permissionRepository;

    public PermissionResponse create(PermissionRequest request) {

        Permission permission = PermissionMapper.toPermission(request);
        permissionRepository.save(permission);
        return PermissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> findAll() {
        return permissionRepository.findAll().stream().map(PermissionMapper::toPermissionResponse).collect(Collectors.toList());
    }

    public void delete(String permissionName) {
        permissionRepository.deleteById(permissionName);
    }
}
