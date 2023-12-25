package com.example.androidproapi.security;

import com.example.androidproapi.security.oauth.OAuth2AuthorizationRequestBasedOnCookieRepository;
import com.example.androidproapi.security.oauth.OAuth2SuccessHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;
import com.example.androidproapi.service.UserService;
import com.example.androidproapi.repository.RefreshTokenRepository;
import com.example.androidproapi.security.oauth.OAuth2UserCustomService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private  OAuth2UserCustomService oAuth2UserCustomService;
    private  TokenProvider tokenProvider;
    private  RefreshTokenRepository refreshTokenRepository;
    private  UserService userService;

    @Autowired
    public SecurityConfig(OAuth2UserCustomService oAuth2UserCustomService, TokenProvider tokenProvider,RefreshTokenRepository refreshTokenRepository,UserService userService){
        this.oAuth2UserCustomService = oAuth2UserCustomService;
        this.tokenProvider = tokenProvider;
        this.refreshTokenRepository = refreshTokenRepository;
        this.userService = userService;
    }

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/img/**", "/css/**", "/js/**");
    }

    /*
    * 필터체인 순서에 유의 해 주세요
    * */
    @Bean
    public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
               .csrf(AbstractHttpConfigurer::disable)
               .httpBasic(AbstractHttpConfigurer::disable)
               .formLogin(AbstractHttpConfigurer::disable)
               .logout(AbstractHttpConfigurer::disable)

               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

               .addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)

               .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/api/auth/**").permitAll()
                                .anyRequest().authenticated()
                )

               .oauth2Login(oauth2Login -> oauth2Login
                       .loginPage("/login").permitAll()
                       .authorizationEndpoint(endpoint ->
                               endpoint.authorizationRequestRepository(oAuth2AuthorizationRequestBasedOnCookieRepository()))
                       .successHandler(oAuth2SuccessHandler())
                       .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.userService(oAuth2UserCustomService))

               )
               .logout(logout -> logout
                       .logoutSuccessUrl("/login")
                )

               .exceptionHandling(exception -> exception
                       .defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
                            new AntPathRequestMatcher("/api/**"))
               )



               .build();
    }

    @Bean
    public OAuth2SuccessHandler oAuth2SuccessHandler() {
        return new OAuth2SuccessHandler(tokenProvider,
                refreshTokenRepository,
                oAuth2AuthorizationRequestBasedOnCookieRepository(),
                userService
        );
    }

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter(tokenProvider);
    }

    @Bean
    public OAuth2AuthorizationRequestBasedOnCookieRepository oAuth2AuthorizationRequestBasedOnCookieRepository() {
        return new OAuth2AuthorizationRequestBasedOnCookieRepository();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}





