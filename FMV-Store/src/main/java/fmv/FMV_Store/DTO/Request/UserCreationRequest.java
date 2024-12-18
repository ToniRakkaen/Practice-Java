package fmv.FMV_Store.DTO.Request;

public class UserCreationRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;

    public UserCreationRequest(){

    }
    public UserCreationRequest(String username, String password, String email, String phone, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
