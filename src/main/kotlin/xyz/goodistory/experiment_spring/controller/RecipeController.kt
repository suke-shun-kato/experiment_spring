package xyz.goodistory.experiment_spring.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import xyz.goodistory.experiment_spring.entity.RecipeEntity
import xyz.goodistory.experiment_spring.repository.RecipeRepository

@Controller
@RequestMapping("/recipes")
class RecipeController {
    companion object {
        const val REDIRECT_TOP = "redirect:/recipes"
    }

    @Autowired
    lateinit var recipeRepository: RecipeRepository

    /**
     * リスト
     */
    @GetMapping("")
    fun index(model: Model): String {
        val recipes = recipeRepository.findAll()
        model.addAttribute("recipes", recipes)
        return "index"
    }

    /**
     * 新規作成
     */
    @GetMapping("/create")
    fun create(model: Model): String {
        return "create_edit"
    }

    /**
     * 新規作成処理
     */
    @PostMapping("")
    fun store(@RequestParam title: String, @RequestParam imageUrl: String, @RequestParam description: String): String {
        recipeRepository.save(RecipeEntity(0, title, imageUrl, description))

        return REDIRECT_TOP
    }

    /**
     * 編集ページ
     */
    @GetMapping("/{id}/edit")
    fun edit(@PathVariable("id") id: String, model: Model): String {
        val recipe: RecipeEntity = recipeRepository.findById(id.toInt()).orElse(null)
            ?: return REDIRECT_TOP

        model.addAttribute("recipe", recipe)
        return "create_edit"
    }

    /**
     * 更新処理
     */
    @PostMapping("/{id}/update")
    fun update(@PathVariable("id") id: String,
               @RequestParam title: String, @RequestParam imageUrl: String, @RequestParam description: String,
               model: Model)
    : String {
        val recipeEntity: RecipeEntity = recipeRepository.findById(id.toInt()).orElse(null)
            ?: return REDIRECT_TOP

        recipeEntity.title = title
        recipeEntity.imageUrl = imageUrl
        recipeEntity.description = description

        recipeRepository.save(recipeEntity)

        return REDIRECT_TOP
    }

    /**
     * 削除処理
     */
    @PostMapping("/{id}/delete")
    fun destroy(@PathVariable("id") id: String) : String {

        val recipeEntity: RecipeEntity = recipeRepository.findById(id.toInt()).orElse(null)
            ?: return REDIRECT_TOP

        recipeRepository.delete(recipeEntity)

        return REDIRECT_TOP
    }

}