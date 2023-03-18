package xyz.goodistory.experiment_spring.repository

import org.springframework.data.repository.CrudRepository
import xyz.goodistory.experiment_spring.entity.RecipeEntity

interface RecipeRepository : CrudRepository<RecipeEntity, Int>