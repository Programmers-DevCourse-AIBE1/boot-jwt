package org.example.bootjwt.controller;

import org.example.bootjwt.auth.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/test")
public class TestController {
    private final JwtTokenProvider jwtTokenProvider;

    public TestController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/")
    public String index(Model model, Authentication auth) {
        String token = jwtTokenProvider.createToken(auth);
        model.addAttribute("jwt", token);
        return "index";
    }
}
