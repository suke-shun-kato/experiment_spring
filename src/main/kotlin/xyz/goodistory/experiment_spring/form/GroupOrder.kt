package xyz.goodistory.experiment_spring.form

import jakarta.validation.GroupSequence

@GroupSequence(ValidGroup1st::class, ValidGroup2nd::class)
interface GroupOrder {
}