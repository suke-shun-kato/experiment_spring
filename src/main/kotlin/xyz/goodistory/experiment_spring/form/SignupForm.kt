package xyz.goodistory.experiment_spring.form

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length

/**
 * ユーザー登録ページのフォームクラス
 */
data class SignupForm (
    // kotlinのコンストラクターにvalを指定して@NotBlankなどのアノテーションを付けた場合、
    // コンストラクターの引数、フィールド、ゲッターに全てにアノテーションを付けたことになるので、
    // フィールドだけにアノテーションをつける場合は @field: として指定する
    @field: [NotBlank Email]    // @NotBlank @Email の場合
    val email: String?,

    @field: [NotBlank Pattern(regexp = "^[a-zA-Z0-9_]+$") Length(min = 8, max=100)]
    val password: String?,

    @field: Min(0)  // @Min(0) の場合
    val age: Int?
)