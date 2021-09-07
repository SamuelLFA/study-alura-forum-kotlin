package com.samuellima.forum_alura.mapper

import com.samuellima.forum_alura.dto.TopicView
import com.samuellima.forum_alura.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {

    override fun map(topic: Topic): TopicView {
        return TopicView(
            topic.id!!,
            topic.title,
            topic.message,
            topic.status,
            topic.createdAt
        )
    }
}