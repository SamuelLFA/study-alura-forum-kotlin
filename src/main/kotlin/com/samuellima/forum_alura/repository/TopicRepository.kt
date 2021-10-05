package com.samuellima.forum_alura.repository

import com.samuellima.forum_alura.dto.TopicByCategoryDto
import com.samuellima.forum_alura.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String, pagination: Pageable): Page<Topic>

    @Query("SELECT NEW com.samuellima.forum_alura.dto.TopicByCategoryDto(Course.category, COUNT(t)) FROM Topic t JOIN t.course Course GROUP BY Course.category")
    fun report(): List<TopicByCategoryDto>
}