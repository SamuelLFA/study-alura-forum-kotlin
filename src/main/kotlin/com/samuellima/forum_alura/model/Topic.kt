package com.samuellima.forum_alura.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "topics")
data class Topic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "title")
    val title: String,

    @Column(name = "message")
    val message: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: Course,

    @ManyToOne
    val author: User,

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    val status: TopicState = TopicState.NOT_ANSWERED,

    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList()
)