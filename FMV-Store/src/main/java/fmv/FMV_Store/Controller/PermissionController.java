package fmv.FMV_Store.Controller;

import fmv.FMV_Store.DTO.Request.ApiResponse;
import fmv.FMV_Store.DTO.Request.PermissionRequest;
import fmv.FMV_Store.DTO.Response.PermissionResponse;
import fmv.FMV_Store.Service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionResponse> createPermission(@RequestBody PermissionRequest request) {
        return ApiResponse
                .<PermissionResponse>builder()
                .data(permissionService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getAllPermissions() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .data(permissionService.findAll())
                .build();
    }

    @DeleteMapping("/{request}")
    ApiResponse<Void> deletePermission(@PathVariable String request) {
        permissionService.delete(request);
        return ApiResponse.<Void>builder().build();
    }
}
