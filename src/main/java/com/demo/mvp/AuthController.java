package com.demo.mvp;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepo users;
    public AuthController(UserRepo users){this.users=users;}

    public record LoginReq(String username, String password) {}
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody LoginReq req){
        return users.findByUsername(req.username())
            .filter(u -> u.getPassword().equals(req.password()))
            .map(u -> Map.<String,Object>of("token", u.getToken(), "name", u.getName(), "role", u.getRole().name()))
            .orElse(Map.of("error","Invalid credentials"));
    }
}