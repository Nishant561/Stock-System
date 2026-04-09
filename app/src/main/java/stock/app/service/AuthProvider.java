package stock.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import stock.app.service.UserDetailService;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            UserDetails foundUser = userDetailService.loadUserByUsername(email);
            if (!passwordEncoder.matches(password, foundUser.getPassword())) {
                throw new BadCredentialsException("Bad Credentials!");
            }
            return new UsernamePasswordAuthenticationToken(
                    foundUser.getUsername(),
                    foundUser.getPassword(),
                    foundUser.getAuthorities()
            );
        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException("Bad Credentials!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}