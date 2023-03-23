package xyz.goodistory.experiment_spring.entity

import jakarta.persistence.*

@Entity
@Table(name = "m_users", indexes = [Index(columnList = "email", unique = true)])
data class MUserEntity (
    /**  id */
    @Id // 主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    val id: Int = 0,

    /** E-mail */
    var email: String,

    /** パスワード */
    var password: String,

    /** 年齢 */
    var age: Int?
)