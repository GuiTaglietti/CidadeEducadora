package br.upf.cidadeeducadora.repository

import br.upf.cidadeeducadora.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface UsuarioRepository: JpaRepository<Usuario, Long>{
    fun findByEmail(email: String): UserDetails?
}