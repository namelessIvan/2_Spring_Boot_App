package learning.springcourse.web.controller;


import learning.springcourse.web.model.User;
import learning.springcourse.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users") // Базовый URL для эндпойнтов пользователя
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user){
        User createdUser = userService.createUser("email.com", "8928", "FOI", "ADMIN");
        return ResponseEntity.status(201).body(createdUser);
    }
}
