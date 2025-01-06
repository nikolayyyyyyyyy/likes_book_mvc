package like_book.web;

import like_book.config.UserSession;
import like_book.models.entities.Post;
import like_book.services.PostService;
import like_book.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {
    private final UserSession userSession;
    private final UserService userService;
    private final PostService postService;

    public HomeController(UserSession userSession,
                          UserService userService,
                          PostService postService) {
        this.userSession = userSession;
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model){

        if(!userSession.isLoggedIn()){

            return "redirect:/register";
        }
        List<Post> myPosts = this.postService
                .getAllPostByUser(this.userService.getByUsername(userSession.getUsername()));

        List<Post> otherPosts = this
                .postService
                .getAllPosts()
                .stream()
                .filter(u -> !Objects.equals(u.getUser().getUsername(), this.userSession.getUsername()))
                .toList();

        String username = this.userSession.getUsername();
        model.addAttribute("myPosts",myPosts);
        model.addAttribute("otherPosts",otherPosts);
        model.addAttribute("username",username);

        return "home";
    }
}
