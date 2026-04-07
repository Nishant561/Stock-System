package stock.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import stock.app.dto.UserDTO;
import stock.app.enums.UserRoles;
import stock.app.errors.FailedUserCreation;
import stock.app.mapper.UserMapper;
import stock.app.models.Role;
import stock.app.models.User;
import stock.app.repository.RoleRepo;
import stock.app.repository.UserRepo;
import stock.app.response.EndUserResponse;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    private final UserMapper userMapper;

    @Autowired
    public AuthService(UserRepo userRepo, RoleRepo roleRepo, UserMapper userMapper){
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public EndUserResponse createNewUser(UserDTO userDTO){

        Optional<User> userAlreadyExist = userRepo.findByEmail(userDTO.getEmail());

        if(userAlreadyExist.isPresent()) return new EndUserResponse(
                "User Already Exist Please Login To Continue!",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        Optional<Role> userRole = roleRepo.findByRoleName(UserRoles.USER);



        User registeredUser = userMapper.mapUserDtoToUserEntity(userDTO) ;

        userRole.ifPresent(role -> registeredUser.getUserRole().add(role));

       User savedUser =  userRepo.save(registeredUser);


        return new EndUserResponse(
                "SignUp Successfully!",
                HttpStatus.CREATED.value(),
                LocalDateTime.now()
        );



    }


    public EndUserResponse login(UserDTO userDTO){
     Optional<User> user = userRepo.findByEmail(userDTO.getEmail());

     if(user.isEmpty()){
         return new EndUserResponse(
                 "User Dosen't Exist!",
                 HttpStatus.BAD_REQUEST.value(),
                 LocalDateTime.now()
         );

     }

     if(!user.get().getPassword().equals( userDTO.getPassword())){
         return new EndUserResponse(
                 "Incorrect Password!",
                 HttpStatus.BAD_REQUEST.value(),
                 LocalDateTime.now()
         );
     }

     return new EndUserResponse(
             "LoggedIn Successfully!",
             HttpStatus.OK.value(),
             LocalDateTime.now()
     );

    }




}
