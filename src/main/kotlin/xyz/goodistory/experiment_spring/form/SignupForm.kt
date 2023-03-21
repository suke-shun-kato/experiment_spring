package xyz.goodistory.experiment_spring.form

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

/**
 * ユーザー登録ページのフォームクラス
 */
class SignupForm (
    @NotBlank
    @Email
    val email: String?,

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    val password: String?,

    @Min(0)
    val age: Int?
)