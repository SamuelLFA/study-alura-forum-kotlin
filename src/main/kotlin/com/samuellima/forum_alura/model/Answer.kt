package com.samuellima.forum_alura.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "answers")
data class Answer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long? = null,

        @Column(name = "message")
        val message: String,

        @Column(name = "created_at")
        val createdAt: LocalDateTime = LocalDateTime.now(),

        @ManyToOne
        val author: User,

        @ManyToOne
        val topic: Topic,

        @Column(name = "solution")
        val solution: Boolean
)