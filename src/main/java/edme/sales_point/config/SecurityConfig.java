package edme.sales_point.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {


//    private final JwtTokenFilter jwtTokenFilter;
//
//    // Внедрение кастомного фильтра для обработки JWT
//    public SecurityConfig(JwtTokenFilter jwtTokenFilter) {
//        this.jwtTokenFilter = jwtTokenFilter;
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//       http
//            .csrf().disable()  // Отключаем CSRF для API
//            .authorizeRequests()
//                .antMatchers("/auth/login", "/auth/register").permitAll() // Открытые эндпоинты для входа и регистрации
//                .anyRequest().authenticated() // Все остальные запросы требуют аутентификацию
//            .and()
//            .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class); // Добавляем JWT фильтр
//
//        return http.build();

        return http.build();
    }



}
