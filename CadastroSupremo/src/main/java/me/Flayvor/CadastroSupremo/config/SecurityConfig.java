package me.Flayvor.CadastroSupremo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Usa o BCrypt, que é o padrão ouro para hashing de senhas.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita o CSRF, pois não estamos usando sessões/cookies para autenticação.
                // APIs RESTful são "stateless".
                .csrf(csrf -> csrf.disable())

                // Define a política de gerenciamento de sessão como STATELESS.
                // O servidor não guardará estado de sessão do cliente.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Configura as regras de autorização para as requisições HTTP.
                .authorizeHttpRequests(authorize -> authorize
                        // Permite que qualquer requisição (permitAll) para qualquer endpoint (anyRequest)
                        // seja acessada sem autenticação.
                        // ATENÇÃO: Isso é temporário para não quebrar sua API durante o desenvolvimento.
                        // No futuro, você pode restringir endpoints específicos.
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
