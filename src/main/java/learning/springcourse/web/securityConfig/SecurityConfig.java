package learning.springcourse.web.securityConfig;


import learning.springcourse.web.filter.CustomAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private CustomAuthFilter customAuthFilter;

    @Autowired
    public SecurityConfig(CustomAuthFilter customAuthFilter) {
        this.customAuthFilter = customAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        auth -> auth

                                .requestMatchers(HttpMethod.POST, "/api/orders").hasAnyAuthority("USER", "ADMIN") // создание заказа
                                .requestMatchers(HttpMethod.GET, "/api/orders/{id}").hasAnyAuthority("USER", "ADMIN") // получение заказа по ID
                                .requestMatchers(HttpMethod.PUT, "/api/orders/**").hasAuthority("ADMIN") // изменение заказа
                                .requestMatchers(HttpMethod.DELETE, "/api/orders/**").hasAuthority("ADMIN") // удаление заказа
                )
                .addFilterBefore(customAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .build();
    }

}
