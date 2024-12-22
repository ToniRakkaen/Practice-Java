package fmv.FMV_Store.DTO.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3, message = "USER_INVALID")
    String username;

    @Size(min = 5, message = "PASSWORD_INVALID")
    String password;
    @NotEmpty
    String email;
    String phone;
    String role;

}
