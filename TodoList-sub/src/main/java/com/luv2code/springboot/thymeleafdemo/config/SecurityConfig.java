package com.luv2code.springboot.thymeleafdemo.config;

import com.luv2code.springboot.thymeleafdemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    MemberService memberService;
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http.authorizeHttpRequests(authz -> authz
                            .anyRequest().authenticated()
                    ).formLogin(form ->
                    form.loginPage("/members/login")
                            .defaultSuccessUrl("/")
                            .usernameParameter("email")
                            .failureUrl("/members/login/error")
            ).logout(logout -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher(("/members/;logout")))
                    .logoutSuccessUrl("/"));

                    return http.build();

        }
        @Bean
        public PasswordEncoder passwordEncoder () {
            return new BCryptPasswordEncoder();
        }

            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
            }


            public void configure(WebSecurity web) throws Exception {
                web.ignoring()
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
            }
        }


