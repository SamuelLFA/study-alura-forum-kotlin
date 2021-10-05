package com.samuellima.forum_alura.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "users")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long? = null,

        @Column(name = "name")
        val name: String,

        @Column(name = "email")
        val email: String,

        @Column(name = "password")
        val password: String,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = [JoinColumn(name = "user_id")],
                inverseJoinColumns = [JoinColumn(name = "role_id")]
        )
        val roles: List<Role> = mutableListOf()
)