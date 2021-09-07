package com.samuellima.forum_alura.mapper

import com.samuellima.forum_alura.dto.form.CreateTopicForm
import com.samuellima.forum_alura.model.Topic
import com.samuellima.forum_alura.service.CourseService
import com.samuellima.forum_alura.service.UserService
import org.springframework.stereotype.Component

@Component
class CreateTopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
) : Mapper<CreateTopicForm, Topic> {

    override fun map(t: CreateTopicForm): Topic {

        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.getById(t.idCourse),
            author = userService.getById(t.idAuthor)
        )
    }
}