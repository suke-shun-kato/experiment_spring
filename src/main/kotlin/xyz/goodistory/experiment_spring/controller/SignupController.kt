package xyz.goodistory.experiment_spring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import xyz.goodistory.experiment_spring.form.GroupOrder
import xyz.goodistory.experiment_spring.form.SignupForm

@Controller
@RequestMapping("/user")
class SignupController {

    /**
     * ユーザー登録画面
     */
    @GetMapping("/signup")
    fun create(model: Model, @ModelAttribute form: SignupForm): String {

        return "user/signup"
    }

    /**
     * ユーザー登録処理
     */
    @PostMapping("/signup")
    // BindingResult は フォームの後に引数を書かないといけない
    fun store(
        model: Model,
        @ModelAttribute @Validated(GroupOrder::class) signupForm: SignupForm,
        bindingResult: BindingResult): String {

        if (bindingResult.hasErrors()) {
            return create(model, signupForm)
        }

        return "redirect:/login"
    }

}