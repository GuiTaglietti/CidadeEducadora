package br.upf.cidadeeducadora.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
@Entity
data class Curso(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val data: LocalDate,
    val dataInicio: LocalDateTime,
    val dataFim: LocalDateTime,
    val descricao: String,
    @Enumerated(value = EnumType.STRING)
    val status: StatusCurso,
    @OneToMany(mappedBy = "curso")
    val inscritos: List<Inscricao> = listOf()
)
