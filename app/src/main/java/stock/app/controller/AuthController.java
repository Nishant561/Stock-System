package stock.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock.app.models.User;
import stock.app.repository.UserRepo;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signup")
    public String createNewAccount(@RequestBody User user){
       User userOne = userRepo.save(user);
       return "User Created Successfully!";
    }



}
