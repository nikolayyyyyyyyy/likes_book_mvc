package like_book.web;
import jakarta.validation.Valid;
import like_book.models.dtos.UserLoginDTO;
import like_book.models.dtos.UserRegisterDTO;
import like_book.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegistrationModel")
    public UserRegisterDTO userRegisterDTO(){
        return new UserRegisterDTO();
    }

    @ModelAttribute("userLoginModel")
    public UserLoginDTO userLoginDTO(){
        return new UserLoginDTO();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            return "redirect:/register";
        }

        boolean success = this
                .userService
                .createUser(userRegisterDTO);

        if(!success){
            return "redirect:/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO userLoginDTO,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            return "redirect:/login";
        }

        boolean success = this.userService.login(userLoginDTO);

        if(!success){
            return "redirect:/login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        this.userService.logout();

        return "redirect:/login";
    }
}