package stock.app.mapper;

import org.springframework.stereotype.Component;
import stock.app.dto.UserDTO;
import stock.app.models.User;

@Component
public class UserMapper {

    public  User mapUserDtoToUserEntity(UserDTO userDTO){
        User newUser = new User();

        newUser.setUserName(userDTO.getUserName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());
        newUser.setIsActive(true);
        newUser.setIsEmailVerified(false);

        return newUser;

    }
}
