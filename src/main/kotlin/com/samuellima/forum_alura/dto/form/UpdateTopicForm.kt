package com.samuellima.forum_alura.dto.form

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UpdateTopicForm (
    @field:NotEmpty @field:Size(min = 1, max = 100)
    val title: String,
    @field:NotEmpty
    val message: String
)