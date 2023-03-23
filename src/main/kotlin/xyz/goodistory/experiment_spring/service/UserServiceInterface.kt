package xyz.goodistory.experiment_spring.service

import xyz.goodistory.experiment_spring.form.SignupForm

interface UserServiceInterface {
    /**
     * ユーザー登録
     */
    fun signup(signupForm: SignupForm)
}