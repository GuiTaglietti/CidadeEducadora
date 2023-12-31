package br.upf.cidadeeducadora.dtos

import br.upf.cidadeeducadora.model.StatusCurso
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

data class CursoDTO(
        @field:NotEmpty(message = "Um curso sempre deve possuir um nome!")
        val nome: String,
        @field:NotNull(message = "Um curso sempre deve possuir uma data!")
        val data: LocalDate,
        val descricao: String,
        @field:NotNull(message = "Um status para a situação em que o curso se encontra deve ser fornecido!")
        val status: StatusCurso
)
