package com.samuellima.forum_alura.dto

import com.samuellima.forum_alura.model.TopicState
import java.time.LocalDateTime

data class TopicView(
    val id: Long,
    val title: String,
    val message: String,
    val status: TopicState,
    val createdAt: LocalDateTime
)