package br.upf.cidadeeducadora.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime
@Entity
data class Inscricao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    val usuario: Usuario,
    @ManyToOne
    val curso: Curso,
    val data: LocalDateTime = LocalDateTime.now()
)
