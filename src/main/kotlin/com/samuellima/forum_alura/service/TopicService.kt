package com.samuellima.forum_alura.service

import com.samuellima.forum_alura.dto.form.UpdateTopicForm
import com.samuellima.forum_alura.exception.NotFoundException
import com.samuellima.forum_alura.model.Topic
import com.samuellima.forum_alura.repository.TopicRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
    @Autowired private val topicRepository: TopicRepository
) : BaseService<Topic, UpdateTopicForm> {

    private val topicNotFoundExceptionMessage: String = "This topic does not exist"

    fun list(
        courseName: String?,
        pagination: Pageable): Page<Topic>
    {
        return if (courseName == null) {
            topicRepository
                .findAll(pagination)
        } else {
            topicRepository.findByCourseName(courseName, pagination)
        }
    }

    override fun getById(id: Long): Topic {
        return topicRepository
            .findById(id)
            .orElseThrow { NotFoundException(topicNotFoundExceptionMessage) }
    }

    override fun create(model: Topic) {
        topicRepository.save(model)
    }

    override fun update(id: Long, form: UpdateTopicForm): Topic {
        val oldTopic = getById(id)

        val topicUpdated = Topic(
            oldTopic.id,
            form.title,
            form.message,
            oldTopic.createdAt,
            oldTopic.course,
            oldTopic.author,
            oldTopic.status,
            oldTopic.answers
        )

        topicRepository.save(topicUpdated)

        return topicUpdated
    }

    override fun delete(id: Long) {
        val topicToDelete = getById(id)
        topicRepository.delete(topicToDelete)
    }
}