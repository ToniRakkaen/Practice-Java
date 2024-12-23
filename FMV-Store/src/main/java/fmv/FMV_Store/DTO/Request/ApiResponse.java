package fmv.FMV_Store.DTO.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
//Dung de bo cac thuoc tinh == null ra khoi api
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T> {
    int code;
    String message;
    T data;
}
