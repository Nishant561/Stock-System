package stock.app.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stock.app.dto.UserDTO;
import stock.app.models.User;
import stock.app.repository.UserRepo;
import stock.app.response.EndUserResponse;
import stock.app.service.AuthService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class AuthController {


    private final AuthService authService;

    @Autowired
    public AuthController (AuthService authService){
        this.authService = authService;
    }

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signup")
    public ResponseEntity<?> createNewAccount(@Valid @RequestBody UserDTO userDTO){
        EndUserResponse res = authService.createNewUser(userDTO);

       return ResponseEntity.status(res.getStatusCode()).body(res);

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO){
        EndUserResponse res = authService.login(userDTO);

        return ResponseEntity.status(res.getStatusCode()).body(res);
    }



}
