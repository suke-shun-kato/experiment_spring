package xyz.goodistory.experiment_spring.entity

import jakarta.persistence.*

@Entity
@Table(name = "recipes")
data class RecipeEntity (
    /**  id */
    @Id // 主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    val id: Int = 0,

    /** レシピタイトル */
    val title: String = "",

    /** レシピの画像URL */
    val imageUrl: String? = null,

    /** レシピの説明本体 */
    val description: String = "",
)