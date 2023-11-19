package br.upf.cidadeeducadora.service

import br.upf.cidadeeducadora.converters.UsuarioConverter
import br.upf.cidadeeducadora.dtos.UsuarioDTO
import br.upf.cidadeeducadora.dtos.UsuarioResponseDTO
import br.upf.cidadeeducadora.exceptions.NotFoundException
import br.upf.cidadeeducadora.repository.UsuarioRepository
import org.springframework.stereotype.Service

private const val USER_NOT_FOUND_MESSAGE: String = "Usuário não encontrado ou inexistente!"
@Service
class UsuarioService(private val repo: UsuarioRepository, private val converter: UsuarioConverter){
    fun listAll(): List<UsuarioResponseDTO>{
        return repo.findAll().map(converter::toUsuarioResponseDTO)
    }
    fun searchById(id: Long): UsuarioResponseDTO{
        val usuario = repo.findById(id).orElseThrow{ NotFoundException(USER_NOT_FOUND_MESSAGE) }
        return converter.toUsuarioResponseDTO(usuario)
    }
    fun register(dto: UsuarioDTO): UsuarioResponseDTO{
        return converter.toUsuarioResponseDTO(repo.save(converter.toUsuario(dto)))
    }
    fun update(id: Long, dto: UsuarioDTO): UsuarioResponseDTO{
        val usuario = repo.findById(id).orElseThrow{ NotFoundException(USER_NOT_FOUND_MESSAGE) }
                      .copy(
                            nome = dto.nome,
                            cidade = dto.cidade,
                            telefone = dto.telefone
                      )
        return converter.toUsuarioResponseDTO(repo.save(usuario))
    }
    fun delete(id: Long){
        repo.deleteById(id)
    }
}