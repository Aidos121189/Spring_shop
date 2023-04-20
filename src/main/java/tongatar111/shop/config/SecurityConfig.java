package tongatar111.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests(authorizationConfigurer -> {
            //authorizationConfigurer.antMatchers("/security_test/second_resource").authenticated();
            authorizationConfigurer.antMatchers("/cart/**").authenticated();
            authorizationConfigurer.antMatchers("/personal/**").authenticated();


            authorizationConfigurer.antMatchers("/admin/**").hasRole("ADMIN");
            authorizationConfigurer.antMatchers("/product_add/select_category").hasRole("ADMIN");
            authorizationConfigurer.antMatchers("/moderation/**").hasRole("ADMIN");
            authorizationConfigurer.anyRequest().permitAll();
        });
        http.formLogin();
        http.logout();
        return http.build();

    }
}
