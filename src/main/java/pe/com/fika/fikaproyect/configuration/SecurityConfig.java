package pe.com.fika.fikaproyect.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
     * @Bean
     * public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws
     * Exception {
     * return httpSecurity
     * .authorizeHttpRequests(auth -> {
     * auth.requestMatchers("paciente", "citas").permitAll();
     * auth.anyRequest().authenticated();
     * })
     * .formLogin(login -> login
     * .permitAll())
     * .httpBasic(withDefaults())
     * .build();
     * }
     */

    /*
     * @Bean
     * public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws
     * Exception {
     * return httpSecurity
     * .authorizeHttpRequests(auth -> {
     * auth.requestMatchers("paciente", "citas").permitAll();
     * auth.anyRequest().authenticated();
     * })
     * .formLogin(login -> login
     * .successHandler(successHandler())
     * .permitAll())
     * .sessionManagement(session -> session
     * .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
     * .invalidSessionUrl("/fika/usuario/login")
     * .maximumSessions(1)
     * .expiredUrl("/fika/usuario/login")
     * .sessionRegistry(sessionRegistry()))
     * .sessionManagement(sessionM -> sessionM
     * .sessionFixation().migrateSession())
     * .build();
     * }
     */

    /*
     * @Bean
     * public SessionRegistry sessionRegistry() {
     * return new SessionRegistryImpl();
     * }
     * 
     * public AuthenticationSuccessHandler successHandler() {
     * return ((request, response, authentication) -> {
     * response.sendRedirect("/fika/usuario/session");
     * });
     * }
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity

                .build();
    }

}
