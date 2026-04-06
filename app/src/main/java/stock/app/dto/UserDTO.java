package stock.app.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stock.app.validations.StrongPassword;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer userId;

    @NotBlank(message = "Please provide User-Name!")
    @Size(min = 3, max = 15, message = "Username must be 3 character long!")
    private String userName;

    @NotBlank(message = "Please provide email!")
    @Email(message = "Please provide valid email address!")
    private String email;

    @NotBlank(message = "Please provide password!")
    @StrongPassword(message = "Provide Strong Password With UpperCase, LowerCase, Symbols and Digits!")
    private String password;



}
