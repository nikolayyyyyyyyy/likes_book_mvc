package like_book.web;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import like_book.config.UserSession;
import like_book.models.dtos.PostDTO;
import like_book.models.entities.Post;
import like_book.models.entities.User;
import like_book.services.PostService;
import like_book.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostService postService;
    private final UserSession userSession;
    private final UserService userService;
    public PostController(PostService postService,
                          UserSession userSession,
                          UserService userService) {
        this.postService = postService;
        this.userSession = userSession;
        this.userService = userService;
    }

    @ModelAttribute("postModel")
    public PostDTO postDTO(){
        return new PostDTO();
    }

    @GetMapping("/post-add")
    public String addPost(){
        return "post-add";
    }

    @PostMapping("/post-add")
    public String addPost(@Valid PostDTO postDTO,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            return "redirect:/post-add";
        }

        boolean success = this.postService.createPost(postDTO);

        if(!success){

            return "redirect:/post-add";
        }

        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable(name = "id")long id){
        boolean success = this.postService.deletePost(id);

        if(!success){
            return "redirect:/";
        }

        return "redirect:/";
    }

    @Transactional
    @GetMapping("/like/{id}")
    public String likePost(@PathVariable(name = "id")long id){
        Post postById = this.postService.getPostById(id);
        User user = this.userService.getByUsername(this.userSession.getUsername());

        postById.getUserLikes().add(user);
        user.getLikedPosts().add(postById);

        return "redirect:/";
    }
}
