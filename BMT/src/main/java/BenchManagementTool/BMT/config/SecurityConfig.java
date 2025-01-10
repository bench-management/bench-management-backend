package BenchManagementTool.BMT.config;


import BenchManagementTool.BMT.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter; // Inject the JWT filter

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF (you may want to adjust this for specific needs)
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        // Permit login and verification endpoints
                        .requestMatchers("/api/request-login", "/api/verify-login").permitAll()
                        // Authenticate any other request
                        .anyRequest().authenticated()
                )
                // Add the JwtRequestFilter before UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
