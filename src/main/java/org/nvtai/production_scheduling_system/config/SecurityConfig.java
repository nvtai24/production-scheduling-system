package org.nvtai.production_scheduling_system.config;

import org.nvtai.production_scheduling_system.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();  // Tải thông tin người dùng qua MyUserDetailsService
    }

    // Thêm DaoAuthenticationProvider để xác thực người dùng qua UserDetailsService và PasswordEncoder
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());  // Sử dụng NoOpPasswordEncoder để không mã hóa mật khẩu
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/login", "/css/**", "/js/**").permitAll()  // Cho phép truy cập trang login và các tài nguyên tĩnh
                                .anyRequest().authenticated()  // Các URL khác phải được xác thực
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")  // Trang đăng nhập tùy chỉnh
                                .defaultSuccessUrl("/home", true)  // Chuyển hướng sau khi đăng nhập thành công
                                .failureUrl("/login?error=true")  // Nếu đăng nhập thất bại
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/login?logout=true")
                                .permitAll()
                )
                .csrf(csrf -> csrf.disable());  // Vô hiệu hóa CSRF
        return http.build();
    }
}