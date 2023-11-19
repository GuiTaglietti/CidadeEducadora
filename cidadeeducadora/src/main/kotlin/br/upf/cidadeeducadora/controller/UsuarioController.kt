package br.upf.cidadeeducadora.controller

import br.upf.cidadeeducadora.dtos.UsuarioDTO
import br.upf.cidadeeducadora.dtos.UsuarioResponseDTO
import br.upf.cidadeeducadora.service.UsuarioService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/usuarios")
class UsuarioController(val service: UsuarioService) {
    @GetMapping
    fun listAll(): List<UsuarioResponseDTO>{
        return service.listAll()
    }
    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): UsuarioResponseDTO{
        return service.searchById(id)
    }

    @PostMapping
    @Transactional
    fun register(@RequestBody @Valid dto: UsuarioDTO, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<UsuarioResponseDTO>
    {
        val userResponse = service.register(dto)
        val uri = uriBuilder.path("/usuarios/${userResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(userResponse)
    }
    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long,
               @RequestBody @Valid dto: UsuarioDTO
    ): UsuarioResponseDTO {
        return service.update(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}