package br.upf.cidadeeducadora.service

import br.upf.cidadeeducadora.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService(val repo: UsuarioRepository): UserDetailsService {
    override fun loadUserByUsername(email: String) =
            repo.findByEmail(email)
}