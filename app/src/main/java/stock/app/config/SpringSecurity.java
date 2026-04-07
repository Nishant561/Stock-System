package stock.app.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {


    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( auth ->
                        auth.requestMatchers("/api/user/login","/api/user/signup").permitAll()

                )
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
                return http.build();
    }


}
