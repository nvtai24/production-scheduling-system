package org.nvtai.production_scheduling_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/mylogin", "/css/**", "/js/**", "/images/**").permitAll()  // Cho phép truy cập vào trang đăng nhập và tài nguyên tĩnh
//                                .anyRequest().authenticated()  // Yêu cầu xác thực cho tất cả các yêu cầu còn lại
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/mylogin")  // Đặt trang đăng nhập của bạn ở đường dẫn gốc
                                .permitAll()  // Cho phép truy cập vào trang đăng nhập mà không cần xác thực
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/")  // Chuyển hướng về trang chính sau khi đăng xuất
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionFixation().migrateSession()
                                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                                .invalidSessionUrl("/")
                                .maximumSessions(1)
                                .expiredUrl("/")
                )
                .csrf(csrf ->
                        csrf
                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )
        ;
        return http.build();
    }
}