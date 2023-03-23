package xyz.goodistory.experiment_spring.config

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@EnableWebSecurity
@Configuration
class SecurityConfig {

    companion object {
        const val H2_PATH = "/h2-console/**"
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }


    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            // 認証の設定
            .authorizeHttpRequests { auth ->
                // どのリクエストでも認証OK（パスワード認証不要）
//                auth.anyRequest().permitAll()
                auth
                    // H2のコンソールを認証なしで読み込めるようにする
                    .requestMatchers(AntPathRequestMatcher.antMatcher(H2_PATH)).permitAll()
                    // loginページを認証なしで読み込めるようにする
                    .requestMatchers("/login").permitAll()
                    // ユーザー登録ページ
                    .requestMatchers("/user/signup").permitAll()
                    // CSSやJSファイルを認証なしで読み込めるようにする
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            }

            // HTTP Headerの設定
            .headers { headers ->
                // H2コンソール用
                headers.frameOptions().disable() }

            // CSRFの設定
            .csrf { csrf ->
                // 引数のCSRFの設定を無視する。H2コンソール用。
                csrf.ignoringRequestMatchers(
                    AntPathRequestMatcher.antMatcher(H2_PATH))
            }


        return http.build()
    }
}