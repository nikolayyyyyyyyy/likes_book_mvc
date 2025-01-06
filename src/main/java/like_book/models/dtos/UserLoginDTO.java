package like_book.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {
    @NotBlank
    @Size(min = 5,max = 100)
    private String username;

    @NotBlank
    @Size(min = 2,max = 32)
    private String password;

    public UserLoginDTO() {
    }

    public @NotBlank @Size(min = 5, max = 100) String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank @Size(min = 5, max = 100) String username) {
        this.username = username;
    }

    public @NotBlank @Size(min = 2, max = 32) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 2, max = 32) String password) {
        this.password = password;
    }
}
