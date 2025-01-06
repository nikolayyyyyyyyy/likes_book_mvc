package like_book.config;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class UserSession {
    private long id;
    private String username;

    public boolean isLoggedIn(){
        return this.id != 0;
    }

    public void logIn(long id,String username){
        this.id = id;
        this.username = username;
    }

    public void logOut(){
        this.id = 0;
        this.username = "";
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
}
