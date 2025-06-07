package sn.seck.GestionCliniqueKissi.Service;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static sn.seck.GestionCliniqueKissi.Model.Role.ADMIN;
import static sn.seck.GestionCliniqueKissi.Model.Role.User;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
    private final JWTAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
//    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity

                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer.loginPage("/login"))/*URL GET POUR AFFICHER LA PAGE*/
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST,"/login","/logout","/RegisterRequest").permitAll()
                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                .requestMatchers("/users/**").hasAnyRole("USER")
                .requestMatchers(HttpMethod.POST,"localhost:4200/"
//                 .requestMatchers(HttpMethod.POST,"http://localhost:8135/api/v1/auth/patient/liste")
                ,"/swagger-ui.html","/swagger-ui/**","/v2/api-docs"," /v3/api-docs",
                        "/swagger-resources","/swagger-resources/**","/v3/api-docs/**",
                        "/swagger-ui/**","/configuration/security/**")
                .permitAll()


               // .requestMatchers(POST, "/api/v1/auth/patient/liste/**").hasAnyAuthority(ADMIN.name(),User.name())
//                .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(),MANAGER_DELETE.name())
//                .requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(),MANAGER_CREATE.name())
//                .requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(),MANAGER_UPDATE.name())
//
//
//
//                .requestMatchers(GET, "/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
//                .requestMatchers(DELETE, "/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())
//                .requestMatchers(POST, "/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
//                .requestMatchers(PUT, "/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())
                

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout->
                        logout.logoutUrl("/api/v1/auth/logout")
                                .permitAll()
                            // .addLogoutHandler(logoutHandler)
                              .logoutSuccessHandler((request, response, authentication)->
                                       SecurityContextHolder.clearContext())
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/api/**") // toutes les routes de l'API
//                    .allowedOrigins("http://localhost:4200") // équivalent de allowedOrigins
//                    .allowedMethods("GET", "POST", "PUT", "DELETE") // autorise ces méthodes HTTP
//                    .allowedHeaders("*") // tous les headers autorisés
//                    .allowCredentials(true); // autorise les cookies (si besoin)
//        }


                );

      return httpSecurity.build();




}
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//
//    }
}