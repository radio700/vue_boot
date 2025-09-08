package vue.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {
    @GetMapping("/api/auth/me")
    public String me(@AuthenticationPrincipal UserDetails user) {
        if (user == null) {
            return "anonymous";
        }
        return user.getUsername();
    }
}
