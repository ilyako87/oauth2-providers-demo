package net.jakot.demo.oauth2demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/secure")
    public String secured(Model model, Authentication authentication) {
        if (authentication.getPrincipal() instanceof DefaultOidcUser oidcUser) {
            model.addAttribute("username", oidcUser.getName());
        }
        return "secure";
    }
}
