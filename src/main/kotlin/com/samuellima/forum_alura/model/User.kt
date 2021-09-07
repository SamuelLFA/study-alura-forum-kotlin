package com.samuellima.forum_alura.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long? = null,

        @Column(name = "name")
        val name: String,

        @Column(name = "email")
        val email: String
)