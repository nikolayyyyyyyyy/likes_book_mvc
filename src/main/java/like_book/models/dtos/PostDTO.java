package like_book.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostDTO {
    @NotNull
    @Size(min = 5,max = 150)
    private String content;

    @NotNull
    private String mood;

    public PostDTO() {
    }

    public @NotNull @Size(min = 5, max = 150) String getContent() {
        return content;
    }

    public void setContent(@NotNull @Size(min = 5, max = 150) String content) {
        this.content = content;
    }

    public @NotNull String getMood() {
        return mood;
    }

    public void setMood(@NotNull String mood) {
        this.mood = mood;
    }
}
