package xyz.goodistory.experiment_spring.repository

import org.springframework.data.repository.CrudRepository
import xyz.goodistory.experiment_spring.entity.User

interface UserRepository : CrudRepository<User, Int>