package like_book.models.entities;

import jakarta.persistence.*;
import like_book.models.enums.MoodType;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "moods")
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private MoodType moodType;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "mood",fetch = FetchType.EAGER)
    private Set<Post> posts;

    public Mood() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MoodType getMoodType() {
        return moodType;
    }

    public void setMoodType(MoodType moodType) {
        this.moodType = moodType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mood mood = (Mood) o;
        return id == mood.id && moodType == mood.moodType && Objects.equals(description, mood.description) && Objects.equals(posts, mood.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moodType, description, posts);
    }
}
