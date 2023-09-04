package com.course.courseDemo.config;

import com.course.courseDemo.security.JwtAuthenticationEntryPoint;
import com.course.courseDemo.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests((authz) -> authz.
                requestMatchers(HttpMethod.OPTIONS).permitAll()
                .requestMatchers("/course/registration").permitAll()
                .requestMatchers("/course/addcourse").permitAll()
                .requestMatchers("/course/getcourse").permitAll()
                .requestMatchers("/course/getStudentCourse").permitAll()
                .requestMatchers("/swagger/swagger-ui/**").permitAll()
                .requestMatchers("/swagger-ui.html").permitAll()
                .requestMatchers("/swagger-resources/**").permitAll()
                .requestMatchers("/swagger-resources").permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()
                .requestMatchers("/proxy/**").permitAll()
                .requestMatchers("/auth/login").permitAll()
                .requestMatchers("/console/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/h2/login.jsp").permitAll()
                .anyRequest().authenticated()

        );


        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();//NOSONAR
        corsConfiguration.addAllowedMethod( CorsConfiguration.ALL );
                http.headers().frameOptions().disable();
        http.cors().configurationSource(request -> corsConfiguration);
        http.csrf().disable();//NOSONAR

        return http.build();

    }




}
