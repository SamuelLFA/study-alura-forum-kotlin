package com.samuellima.forum_alura.repository

import com.samuellima.forum_alura.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun findByEmail(email: String?): User?
}