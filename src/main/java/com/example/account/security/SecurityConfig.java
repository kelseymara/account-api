package com.example.account.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//  Establish this application as an Authorization Server.
//  Principals are expected to be authenticated with HTTP basic.
//  Authenticated calls to /account/token return a JWT signed with a private key.

@Configuration
@EnableWebSecurity
public class SecurityConfig {

// 1. Define a SecurityFilterChain bean to manage security configurations
     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         return http

         // 2. Configure session management and CSRF protection:
             // We want a stateless application so the server doesn't need to store session data.
             //  JWTs allow the server to authenticate requests without storing session info :
             .sessionManagement(
                 session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             //  Disables CSRF protection because the app doesn't use sessions, so CSRF tokens are unnecessary.
             .csrf(csrf -> csrf.disable())

             // 3. Inbound requests must be authenticated (except root URL):
             .authorizeHttpRequests( auth -> auth
                 .requestMatchers("/").permitAll()
                 .anyRequest().authenticated()
             )
             // 4. Configure HTTP Basic authentication (default setup):
             .httpBasic(Customizer.withDefaults())
             .build();
     }

     // 5. Create a simple user for testing and authentication:
    //  Override Spring Boot's default user with
    //  our own user, password, and authorities:
    @Bean
    public InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
            User.withUsername("client")
                .password("{noop}DoNotTell")
                .authorities("read")
                .build()
        );
    }
}
