package com.samuellima.forum_alura.model

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table(name = "roles")
data class Role (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    private val name: String
) : GrantedAuthority {

    override fun getAuthority() = name
}