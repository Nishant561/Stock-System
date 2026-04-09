package stock.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import stock.app.models.Role;
import stock.app.models.User;
import stock.app.repository.UserRepo;

import java.util.List;
import java.util.Set;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepo userRepo;



    @Autowired
    public UserDetailService(UserRepo userRepo){
        this.userRepo = userRepo;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

      stock.app.models.User foundUser = userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Unable to find User!"));

        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
                foundUser.getEmail(),
                foundUser.getPassword(),
                grantedAuthorities(foundUser.getUserRole())

        );

        return user;

    }

    public static List<SimpleGrantedAuthority> grantedAuthorities(Set<Role> roles){
        return roles.stream().map(
                role -> {
                    return new SimpleGrantedAuthority(role.getRoleName().toString());
                }
        ).toList();
    }
}
