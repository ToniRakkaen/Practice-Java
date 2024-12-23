package fmv.FMV_Store.Exception;

public enum ErrorCode {
    UNDEFINED_ERROR(9999, "Undefined exception"),
    INVALID_KEY(9998, "Invalid key"),
    USER_EXISTED(1001, "User has already exists"),
    USER_INVALID(1002, "User must at least 3 characters"),
    PASSWORD_INVALID(1003, "Password must at least 3 characters"),
    USER_NOT_FOUND(1004, "User not found"),
    ;
    private int code;
    private String message;
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
