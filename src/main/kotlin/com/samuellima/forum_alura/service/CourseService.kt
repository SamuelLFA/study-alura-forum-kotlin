package com.samuellima.forum_alura.service

import com.samuellima.forum_alura.exception.NotFoundException
import com.samuellima.forum_alura.model.Course
import com.samuellima.forum_alura.repository.CourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CourseService(@Autowired private val courseRepository: CourseRepository): BaseService<Course, Course> {

    fun list(courseName: String?, pagination: Pageable): List<Course> {
        return courseRepository.findAll()
    }

    override fun getById(id: Long): Course {
        return courseRepository
            .findById(id)
            .orElseThrow { NotFoundException("This course does not exist") }
    }

    override fun create(model: Course) {
       courseRepository.save(model)
    }

    override fun update(id: Long, model: Course): Course {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}