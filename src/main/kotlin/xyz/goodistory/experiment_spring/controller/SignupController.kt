package xyz.goodistory.experiment_spring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/user")
class SignupController {

    /**
     * ユーザー登録画面
     */
    @GetMapping("/signup")
    fun create(model: Model): String {
        return "user/signup"
    }

    /**
     * ユーザー登録処理
     */
    @PostMapping("/signup")
    fun store(): String {
        return "redirect:/login"
    }

}