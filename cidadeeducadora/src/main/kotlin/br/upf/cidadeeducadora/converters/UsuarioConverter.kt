package br.upf.cidadeeducadora.converters

import br.upf.cidadeeducadora.dtos.UsuarioDTO
import br.upf.cidadeeducadora.dtos.UsuarioResponseDTO
import br.upf.cidadeeducadora.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioConverter{
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO{
        return UsuarioResponseDTO(
                id = usuario.id,
                nome = usuario.nome,
                cidade = usuario.cidade,
                telefone = usuario.telefone,
        )
    }
    fun toUsuario(dto: UsuarioDTO): Usuario{
        return Usuario(
                nome = dto.nome,
                cidade = dto.cidade,
                telefone = dto.telefone,
        )
    }
}