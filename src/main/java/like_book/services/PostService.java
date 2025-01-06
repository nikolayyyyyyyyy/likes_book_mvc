package like_book.services;

import like_book.models.dtos.PostDTO;
import like_book.models.entities.Post;
import like_book.models.entities.User;

import java.util.List;

public interface PostService {

    public boolean createPost(PostDTO postDTO);
    public List<Post> getAllPostByUser(User user);
    public List<Post> getAllPosts();
    public boolean deletePost(long id);
    public Post getPostById(long id);
}
