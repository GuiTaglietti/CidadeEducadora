'use client';

import { useEffect, useState } from "react";
import { excluirCurso, atualizarCurso, cadastrarCurso, fetchCursos } from "... @/service/cursoService";
import Layout from "... @/components/cursos/layout";
import Tabela from "... @/components/cursos/tabela";
import Botao from "... @/components/cursos/botao";
import Curso from "... @/core/Curso"
import Formulario from "... @/components/cursos/formulario";


export default function Cursos() {
    const [curso, setCurso] = useState<Curso>(Curso.vazio())
    const [visivel, setVisivel] = useState<'tabela' | 'form'>('tabela')
    const [cursos, setCursos] = useState<Curso[]>([]);

    useEffect(() => {
        if (visivel === 'tabela') {
            const loadCursos = async () => {
                try {
                    const dados = await fetchCursos();
                    setCursos(dados);
                } catch (error) {
                    console.error("Erro ao buscar cursos:", error);
                }
            }
            loadCursos();
        }
    }, [visivel]);

    async function salvarCurso(curso: Curso) {
        try {
            const novoCurso = await cadastrarCurso(curso);
            setVisivel("tabela");
        } catch (error) {
            console.error("Erro ao salvar curso:", error);
        }
    }

    async function alterarCurso(curso: Curso) {
        try {
            const cursoAtualizado = await atualizarCurso(curso);
            setVisivel("tabela");
        } catch (error) {
            console.error("Erro ao atualizar curso:", error);
        }
    }

    function salvarOuAlterarCurso(curso: Curso) {
        if (curso.id) {
            alterarCurso(curso)
        } else {
            salvarCurso(curso)
        }
    }

    function cursoSelecionado(curso: Curso) {
        setCurso(curso)
        setVisivel('form')
    }

    async function cursoExcluido(curso: Curso) {
        const confirmacao = window.confirm("Tem certeza de que deseja excluir este curso?");
        if (confirmacao) {
            try {
                if (curso.id !== null) {
                    await excluirCurso(curso.id);
                } else {
                    console.error("cursoId é null!");
                }
                setCursos(prevCursos => prevCursos.filter(ev => ev.id !== curso.id));
            } catch (error) {
                console.error("Erro ao excluir curso:", error);
            }
        }
    }

    function novoCurso() {
        setCurso(Curso.vazio())
        setVisivel("form")
    }

    return (
        <div className={`flex justify-center items-center h-screen bg-gradient-to-bl from-black via-purple-800 to-black text-white`}>
            <Layout titulo="Cadastro de cursos - Cidade educadora">
                {visivel === 'tabela' ? (
                    <> <div className="flex justify-end">
                        <Botao className="mb-4 bg-purple-800 text-white"
                            onClick={() => novoCurso()}>
                            Novo curso </Botao>
                    </div>
                        <Tabela cursos={cursos}
                            cursoSelecionado={cursoSelecionado}
                            cursoExcluido={cursoExcluido}></Tabela>
                    </>
                ) : (<Formulario curso={curso}
                    cursoMudou={salvarOuAlterarCurso}
                    cancelado={() => setVisivel('tabela')} />)}
            </Layout>
        </div>
    )
}