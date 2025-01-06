package like_book.web;

import jakarta.validation.Valid;
import like_book.models.dtos.PostDTO;
import like_book.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
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
}
