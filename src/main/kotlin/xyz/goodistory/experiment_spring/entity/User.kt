package xyz.goodistory.experiment_spring.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class User (
    @Id // 主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    val id: Int = 0,
    val name: String = ""
)