package br.upf.cidadeeducadora.repository

import br.upf.cidadeeducadora.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long>{
}