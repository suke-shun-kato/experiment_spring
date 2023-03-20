package xyz.goodistory.experiment_spring.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@EnableWebSecurity
@Configuration
class SecurityConfig {

    companion object {
        const val H2_PATH = "/h2-console/**"
    }
    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            // 認証の設定
            .authorizeHttpRequests { auth ->
                // どのリクエストでも認証OK（パスワード認証不要）
                auth.anyRequest().permitAll()
//                    .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
            }

            // HTTP Headerの設定
            .headers { headers ->
                headers.frameOptions().disable() }

            // CSRFの設定
            .csrf { csrf ->
                // 引数のCSRFの設定を無視する
                csrf.ignoringRequestMatchers(
                    AntPathRequestMatcher.antMatcher(H2_PATH))
            }


        return http.build()
    }
}