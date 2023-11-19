package br.upf.cidadeeducadora.repository

import br.upf.cidadeeducadora.model.Curso
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository: JpaRepository<Curso, Long>{
    fun findByNome(nomeCurso: String, pagination: Pageable): Page<Curso>
}