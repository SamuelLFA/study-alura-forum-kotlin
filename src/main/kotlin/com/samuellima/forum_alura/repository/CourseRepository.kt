package com.samuellima.forum_alura.repository

import com.samuellima.forum_alura.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {}