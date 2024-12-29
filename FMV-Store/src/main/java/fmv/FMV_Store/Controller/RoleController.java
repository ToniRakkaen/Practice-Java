package fmv.FMV_Store.Controller;

import fmv.FMV_Store.DTO.Request.ApiResponse;
import fmv.FMV_Store.DTO.Request.RoleRequest;
import fmv.FMV_Store.DTO.Response.RoleResponse;
import fmv.FMV_Store.Service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class RoleController {
    RoleService roleService;
    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse
                .<RoleResponse>builder()
                .data(roleService.creteRole(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .data(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{request}")
    ApiResponse<Void> delete(@PathVariable String request) {
        roleService.deleteRole(request);
        return ApiResponse.<Void>builder().build();
    }
}
