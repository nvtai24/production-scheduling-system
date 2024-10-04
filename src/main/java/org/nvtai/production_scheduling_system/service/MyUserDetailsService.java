package org.nvtai.production_scheduling_system.service;

import org.nvtai.production_scheduling_system.entity.User;
import org.nvtai.production_scheduling_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Loading user by username: " + username);  // Log để kiểm tra
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        user.getRoles().forEach(role -> {
//            System.out.println("Role: " + role.getRname());  // Kiểm tra vai trò
//            System.out.println("Number of features: " + role.getFeatures().size()); // test
//            role.getFeatures().forEach(feature -> {
//                grantedAuthorities.add(new SimpleGrantedAuthority(feature.getUrl()));
//                System.out.println("Granted Authority: " + feature.getUrl());  // Log quyền để kiểm tra
//            });
//        });

        user.getRoles().forEach(role -> {
            System.out.println("Role: " + role.getRname());
            if (role.getFeatures() == null) {
                System.out.println("Features is null");
            } else {
                System.out.println("Number of features: " + role.getFeatures().size());
                role.getFeatures().forEach(feature -> {
                    System.out.println("hihi");
                    grantedAuthorities.add(new SimpleGrantedAuthority(feature.getUrl()));
                    System.out.println("Granted Authority: " + feature.getUrl());
                });
            }
        });

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),  // Mật khẩu plain text (không mã hóa)
                grantedAuthorities
        );
    }
}