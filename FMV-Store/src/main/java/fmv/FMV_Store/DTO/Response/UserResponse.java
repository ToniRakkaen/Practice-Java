package fmv.FMV_Store.DTO.Response;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String username;
//    String password;
    String email;
    String phone;
    String role;
    @ElementCollection
    Set<String> roles;
}
