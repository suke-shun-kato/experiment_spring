package xyz.goodistory.experiment_spring.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import xyz.goodistory.experiment_spring.entity.RecipeEntity
import xyz.goodistory.experiment_spring.repository.RecipeRepository

@Controller
//@RequestMapping("/recipe")
class RecipeController {
    @Autowired
    lateinit var recipeRepository: RecipeRepository

    @GetMapping("/")
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
    @PostMapping("/")
    fun store(@RequestParam title: String, @RequestParam imageUrl: String, @RequestParam description: String): String {
        recipeRepository.save(RecipeEntity(0, title, imageUrl, description))

        return "redirect:/"
    }

    /**
     * 編集ページ
     */
    @GetMapping("/{id}/edit")
    fun edit(@PathVariable("id") id: String, model: Model): String {
        val recipe: RecipeEntity = recipeRepository.findById(id.toInt()).orElse(null)
            ?: return "redirect:/"

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
            ?: return "redirect:/"

        recipeEntity.title = title
        recipeEntity.imageUrl = imageUrl
        recipeEntity.description = description

        recipeRepository.save(recipeEntity)

        return "redirect:/"
    }

    /**
     * 削除処理
     */
    @PostMapping("/{id}/delete")
    fun destroy(@PathVariable("id") id: String) : String {

        val recipeEntity: RecipeEntity = recipeRepository.findById(id.toInt()).orElse(null)
            ?: return "redirect:/"

        recipeRepository.delete(recipeEntity)

        return "redirect:/"
    }

}