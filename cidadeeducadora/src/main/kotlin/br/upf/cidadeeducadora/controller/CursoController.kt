package br.upf.cidadeeducadora.controller

import br.upf.cidadeeducadora.dtos.CursoDTO
import br.upf.cidadeeducadora.dtos.CursoResponseDTO
import br.upf.cidadeeducadora.service.CursoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/cursos")
class CursoController(val service: CursoService){
    @GetMapping
    fun listAll(@RequestParam(required = false) nomeCurso: String?, @PageableDefault(size = 10) pagination: Pageable):
        Page<CursoResponseDTO> {
        return service.listAll(nomeCurso, pagination)
    }
    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long) : CursoResponseDTO{
        return service.searchById(id)
    }
    @PostMapping
    @Transactional
    fun register(@RequestBody @Valid dto: CursoDTO,
                 uriBuilder: UriComponentsBuilder) :
                 ResponseEntity<CursoResponseDTO>
    {
        val requestResponse = service.register(dto)
        val uri = uriBuilder.path("/cursos/${requestResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(requestResponse)
    }
    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long, @RequestBody @Valid dto: CursoDTO) : CursoResponseDTO{
        return service.update(id, dto)
    }
    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }
}