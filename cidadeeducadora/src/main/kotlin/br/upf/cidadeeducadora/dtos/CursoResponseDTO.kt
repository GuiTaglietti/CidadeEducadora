package br.upf.cidadeeducadora.dtos

import br.upf.cidadeeducadora.model.Inscricao
import br.upf.cidadeeducadora.model.StatusCurso
import java.time.LocalDate
import java.time.LocalDateTime

data class CursoResponseDTO(
        val id: Long?,
        val nome: String,
        val data: LocalDate,
        val dataInicio: LocalDateTime,
        val dataFim: LocalDateTime,
        val descricao: String,
        val status: StatusCurso,
        val inscritos: List<Inscricao>
)
