package xyz.goodistory.experiment_spring.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import xyz.goodistory.experiment_spring.entity.RecipeEntity
import xyz.goodistory.experiment_spring.repository.RecipeRepository

@Controller
class RecipeController {
    @Autowired
    lateinit var recipeRepository: RecipeRepository
    @GetMapping("/")
    fun index(model: Model): String {
        val recipes = recipeRepository.findAll()

        model["title"] = "Blog"
        return "index"
    }

    @GetMapping("/create")
    fun create(model: Model): String {
        return "create"
    }

    @PostMapping("/store")
    fun store(@RequestParam title: String, @RequestParam imageUrl: String, @RequestParam description: String): String {
        recipeRepository.save(RecipeEntity(0, title, imageUrl, description))

        return "redirect:/"
    }
}