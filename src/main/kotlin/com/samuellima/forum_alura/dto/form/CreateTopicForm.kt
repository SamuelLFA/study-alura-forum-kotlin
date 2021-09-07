package com.samuellima.forum_alura.dto.form

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateTopicForm (
    @field:NotNull @field:NotEmpty @field:Size(min = 1, max = 100)
    val title: String,
    @field:NotEmpty
    val message: String,
    @field:NotNull
    val idCourse: Long,
    @field:NotNull
    val idAuthor: Long
)