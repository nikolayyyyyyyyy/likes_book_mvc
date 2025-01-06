package like_book.services.impl;

import like_book.config.UserSession;
import like_book.models.dtos.PostDTO;
import like_book.models.entities.Mood;
import like_book.models.entities.Post;
import like_book.models.entities.User;
import like_book.models.enums.MoodType;
import like_book.repositories.PostRepository;
import like_book.services.MoodService;
import like_book.services.PostService;
import like_book.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final MoodService moodService;
    private final UserSession userSession;
    private final UserService userService;

    public PostServiceImpl(PostRepository postRepository,
                           MoodService moodService,
                           UserSession userSession,
                           UserService userService) {
        this.postRepository = postRepository;
        this.moodService = moodService;
        this.userSession = userSession;
        this.userService = userService;
    }

    @Override
    public boolean createPost(PostDTO postDTO) {
        Mood mood = this
                .moodService
                .getByMoodType(MoodType.valueOf(postDTO.getMood()));

        if(mood == null){

            return false;
        }

        User user = this.userService.getByUsername(userSession.getUsername());

        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setMood(mood);
        post.setUser(user);

        this.postRepository.save(post);
        mood.getPosts().add(post);
        return true;
    }

    @Override
    public List<Post> getAllPostByUser(User user) {
        return List.of();
    }

    @Override
    public List<Post> getAllPosts() {
        return List.of();
    }
}
