package xyz.goodistory.experiment_spring.repository

import org.springframework.data.repository.CrudRepository
import xyz.goodistory.experiment_spring.entity.MUserEntity

interface MUserRepository : CrudRepository<MUserEntity, Int> {
    fun existsByEmail(email: String): Boolean
}