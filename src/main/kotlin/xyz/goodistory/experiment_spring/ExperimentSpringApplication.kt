package xyz.goodistory.experiment_spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExperimentSpringApplication

fun main(args: Array<String>) {
    runApplication<ExperimentSpringApplication>(*args)
}
