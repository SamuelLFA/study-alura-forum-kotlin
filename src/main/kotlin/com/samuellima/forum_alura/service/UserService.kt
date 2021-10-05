package com.samuellima.forum_alura.service

import com.samuellima.forum_alura.exception.NotFoundException
import com.samuellima.forum_alura.model.User
import com.samuellima.forum_alura.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired private val userRepository: UserRepository): BaseService<User, User>, UserDetailsService {

    fun list(courseName: String?, pagination: Pageable): List<User> {
        return userRepository.findAll()
    }

    override fun getById(id: Long): User {
        return userRepository
            .findById(id)
            .orElseThrow { NotFoundException("This user does not exist") }
    }

    override fun create(model: User) {
        userRepository.save(model)
    }

    override fun update(id: Long, model: User) : User {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByEmail(username) ?: throw NotFoundException("User not found")
        return UserDetail(user)
    }
}