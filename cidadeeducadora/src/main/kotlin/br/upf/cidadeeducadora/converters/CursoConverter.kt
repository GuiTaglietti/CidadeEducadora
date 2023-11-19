package br.upf.cidadeeducadora.converters

import br.upf.cidadeeducadora.dtos.CursoDTO
import br.upf.cidadeeducadora.dtos.CursoResponseDTO
import br.upf.cidadeeducadora.model.Curso
import org.springframework.stereotype.Component

@Component
class CursoConverter {
    fun toCurso(dto: CursoDTO) : Curso {
        return Curso(
                nome = dto.nome,
                data = dto.data,
                dataInicio = dto.dataInicio,
                dataFim = dto.dataFim,
                descricao = dto.descricao,
                status = dto.status,
                inscritos = listOf()
        )
    }
    fun toCursoResponseDTO(curso: Curso) : CursoResponseDTO {
        return CursoResponseDTO(
                id = curso.id,
                nome = curso.nome,
                data = curso.data,
                dataInicio = curso.dataInicio,
                dataFim = curso.dataFim,
                descricao = curso.descricao,
                status = curso.status,
                inscritos = curso.inscritos
        )
    }
}