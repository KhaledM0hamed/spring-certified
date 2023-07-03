package com.example.l13basiccontractsinspringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {
    /** we need those:
     * UserDetails -> the user
     * UserDetailsService -> UserDetailsManager
     * PasswordEncoder -> handle passwords
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails u1 = User.withUsername("khaled")
                .password(passwordEncoder().encode("1234"))
                .roles("admin")
                .authorities("write")
                .build();


        UserDetails u2 = User.withUsername("mohamed")
                .password(passwordEncoder().encode("12345"))
                .roles("manager")
                .authorities("read")
                .build();

        manager.createUser(u1);
        manager.createUser(u2);

        return manager;
    }

}
