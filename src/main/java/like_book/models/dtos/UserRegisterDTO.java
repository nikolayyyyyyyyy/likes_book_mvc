package like_book.models.dtos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {
    @NotBlank
    @NotNull
    @Size(min = 5,max = 100)
    private String username;

    @NotBlank
    @NotNull
    @Size(min = 2,max = 32)
    private String password;

    @NotNull
    @NotBlank
    @Email
    private String email;

    public UserRegisterDTO() {
    }

    public @NotBlank @NotNull @Size(min = 5, max = 100) String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank @NotNull @Size(min = 5, max = 100) String username) {
        this.username = username;
    }

    public @NotBlank @NotNull @Size(min = 2, max = 32) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @NotNull @Size(min = 2, max = 32) String password) {
        this.password = password;
    }

    public @NotNull @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @NotBlank @Email String email) {
        this.email = email;
    }
}
