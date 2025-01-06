package like_book.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Post> addedPosts;

    @ManyToMany(mappedBy = "userLikes",fetch = FetchType.EAGER)
    private Set<Post> likedPosts;

    public User() {
        this.addedPosts = new HashSet<>();
        this.likedPosts = new HashSet<>();
    }

    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public Set<Post> getAddedPosts() {
        return addedPosts;
    }

    public void setAddedPosts(Set<Post> addedPosts) {
        this.addedPosts = addedPosts;
    }

    public void setLikedPosts(Set<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
