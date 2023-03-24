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
    // 下記は @NotBlank(groups = ValidGroup1st.class) @Email(groups = ValidGroup2nd.class) の場合
    @field: [
        NotBlank(groups = [ValidGroup1st::class])
        Email(groups = [ValidGroup2nd::class])
    ]
    val email: String?,

    @field: [
        NotBlank(groups = [ValidGroup1st::class])
        Pattern(regexp = "^[a-zA-Z0-9_]+$", groups = [ValidGroup2nd::class])
        Length(min = 8, max = 100, groups = [ValidGroup2nd::class])
    ]
    val password: String?,

    @field: Min(value = 0, groups = [ValidGroup1st::class])  // @Min(value = 0, groups = ValidGroup1st.class) の場合
    val age: Int?
)