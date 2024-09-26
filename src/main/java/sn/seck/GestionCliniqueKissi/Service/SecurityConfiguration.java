package sn.seck.GestionCliniqueKissi.Service;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
    private final JWTAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .and()
                .logout()
                .logoutSuccessUrl("logout_success.html")
                .disable()
                .authorizeHttpRequests()
//               .requestMatchers("/USER/**").hasRole("USER")
//                .requestMatchers("/USER/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST,"http://localhost:7075/api/v1/auth/patient/liste/**"
                ,"/swagger-ui.html","/swagger-ui/**","/v2/api-docs"," /v3/api-docs","/swagger-resources","/v3/api-docs/**",
                        "/swagger-ui/*","/configuration/security/**")
                .permitAll()

//                .requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(),MANAGER_READ.name())
//                .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(),MANAGER_DELETE.name())
//                .requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(),MANAGER_CREATE.name())
//                .requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(),MANAGER_UPDATE.name())
//
////
//                .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())
//
//
//                .requestMatchers(GET, "/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
//                .requestMatchers(DELETE, "/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())
//                .requestMatchers(POST, "/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
//                .requestMatchers(PUT, "/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

                 return httpSecurity.build();

    }
    

}