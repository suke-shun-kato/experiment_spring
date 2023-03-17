package xyz.goodistory.experiment_spring.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import xyz.goodistory.experiment_spring.repository.UserRepository

@Controller
class MainController {
    @Autowired
    lateinit var userRepository: UserRepository
    @GetMapping("/")
    fun index(model: Model): String {
        val users = userRepository.findAll()

        model["title"] = "Blog"
        return "index"
    }

    @GetMapping("/create")
    fun create(model: Model): String {
        return "create"
    }

}