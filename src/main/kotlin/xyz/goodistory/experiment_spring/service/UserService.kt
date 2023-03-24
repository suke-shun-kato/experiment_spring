package xyz.goodistory.experiment_spring.service

import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import xyz.goodistory.experiment_spring.entity.MUserEntity
import xyz.goodistory.experiment_spring.form.SignupForm
import xyz.goodistory.experiment_spring.repository.MUserRepository

@Service
class UserService : UserServiceInterface {

    @Autowired
    lateinit var mUserRepository: MUserRepository

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    lateinit var modelMapper: ModelMapper

    override fun signup(signupForm: SignupForm) {
        if (mUserRepository.existsByEmail(signupForm.email!!)) {
            throw object:DataAccessException("ユーザーが既に存在しています") {
            }
        }

        val userEntity = modelMapper.map(signupForm, MUserEntity::class.java)
        userEntity.password = passwordEncoder.encode(signupForm.password)

        mUserRepository.save(userEntity)
    }
}