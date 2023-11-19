package br.upf.cidadeeducadora.service

import br.upf.cidadeeducadora.converters.CursoConverter
import br.upf.cidadeeducadora.dtos.CursoDTO
import br.upf.cidadeeducadora.dtos.CursoResponseDTO
import br.upf.cidadeeducadora.exceptions.NotFoundException
import br.upf.cidadeeducadora.repository.CursoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val NOT_FOUND_MESSAGE: String = "Curso não encontrado ou inexistente!"
@Service
class CursoService(private val repo : CursoRepository, private val converter: CursoConverter){
    fun listAll(nomeCurso: String?, pagination: Pageable): Page<CursoResponseDTO> {
        val cursos = if (nomeCurso == null) {
            repo.findAll(pagination)
        } else {
            repo.findByNome(nomeCurso, pagination)
        }
        return cursos.map(converter::toCursoResponseDTO)
    }
    fun searchById(id: Long) : CursoResponseDTO{
        val tempCurso = repo.findById(id).orElseThrow{ NotFoundException(NOT_FOUND_MESSAGE) }
        return converter.toCursoResponseDTO(tempCurso)
    }
    fun register(dto: CursoDTO) : CursoResponseDTO{
        return converter.toCursoResponseDTO(repo.save(converter.toCurso(dto)))
    }
    fun update(id: Long, dto: CursoDTO) : CursoResponseDTO{
        val tempCurso = repo.findById(id).orElseThrow{ NotFoundException(NOT_FOUND_MESSAGE) }
                        .copy(
                                nome = dto.nome,
                                data = dto.data,
                                descricao = dto.descricao,
                                status = dto.status
                        )
        return converter.toCursoResponseDTO(repo.save(tempCurso))
    }
    fun delete(id: Long){
        repo.deleteById(id)
    }
}