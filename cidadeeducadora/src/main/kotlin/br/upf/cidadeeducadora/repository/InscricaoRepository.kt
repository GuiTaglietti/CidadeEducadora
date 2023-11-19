package br.upf.cidadeeducadora.repository

import br.upf.cidadeeducadora.model.Inscricao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InscricaoRepository: JpaRepository<Inscricao, Long>{
}