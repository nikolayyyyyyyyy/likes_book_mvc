package like_book.repositories;

import like_book.models.entities.Post;
import like_book.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    public List<Post> findByUser(User user);
}
