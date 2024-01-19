package controllers;

import entities.Users;
import repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/ap/ai/users")
public class UsersController {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working";
    }

    @GetMapping("/all")
    public Iterable<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
